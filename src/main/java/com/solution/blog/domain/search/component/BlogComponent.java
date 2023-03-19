package com.solution.blog.domain.search.component;

import com.solution.blog.domain.search.component.model.DaumBlogDocumentDto;
import com.solution.blog.domain.search.component.model.DaumBlogRs;
import com.solution.blog.domain.search.controller.model.BlogSearchRs;
import com.solution.blog.domain.search.controller.model.SortType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class BlogComponent {

    private final WebClient webClient;

    private final String REST_API_KEY = "408848115a7af9b9806f8b2d9a0666a0";

    public BlogSearchRs searchBlog(String keyword, SortType sortType, Integer page, Integer size) {

        // daum blog open api
        // todo 예외 처리 필요
        DaumBlogRs daumBlogRs = getDaumBlogRs(keyword, sortType, page, size);

        // page 설정
        PageImpl<DaumBlogDocumentDto> daumBlogDocumentPage = getDaumBlogDocumentPage(page, size, daumBlogRs);
        return BlogSearchRs.of(daumBlogDocumentPage);
    }

    private PageImpl<DaumBlogDocumentDto> getDaumBlogDocumentPage(Integer page, Integer size, DaumBlogRs daumBlogRs) {
        PageRequest pageRequest = PageRequest.of(page, size);
        PageImpl<DaumBlogDocumentDto> daumBlogDocumentDtoPage =
                new PageImpl<>(daumBlogRs.getDocuments(), pageRequest, daumBlogRs.getMeta().getTotalCount());
        return daumBlogDocumentDtoPage;
    }

    private DaumBlogRs getDaumBlogRs(String keyword, SortType sortType, Integer page, Integer size) {
        UriComponents uriComponents = getUriComponents(keyword, sortType, page, size);

        return webClient.get()
                .uri(uriComponents.toUri())
                .header(HttpHeaders.AUTHORIZATION, "KakaoAK " + REST_API_KEY)
                .retrieve()
                .bodyToMono(DaumBlogRs.class)
                .block();
    }

    private UriComponents getUriComponents(String keyword, SortType sortType, Integer page, Integer size) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("dapi.kakao.com")
                .path("/v2/search/blog")
                .queryParam("sort", sortType.getKakaoName())
                .queryParam("page", page)
                .queryParam("size", size)
                .queryParam("query", keyword)
                .build();
        return uriComponents;
    }
}
