package com.solution.blog.domain.search.component;

import com.solution.blog.domain.page.PageableDto;
import com.solution.blog.domain.search.component.model.DaumBlogMetaDto;
import com.solution.blog.domain.search.component.model.DaumBlogRs;
import com.solution.blog.domain.search.controller.model.BlogSearchRs;
import com.solution.blog.domain.search.controller.model.SortType;
import lombok.RequiredArgsConstructor;
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
        DaumBlogRs daumBlogRs = getDaumBlogRs(keyword, sortType, page, size);

        DaumBlogMetaDto meta = daumBlogRs.getMeta();
        PageableDto pageableDto = getPageableDto(page, meta.getTotalCount());
        return BlogSearchRs.of(daumBlogRs.getDocuments(), pageableDto);
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

    private PageableDto getPageableDto(Integer page, Integer totalCount) {
        PageableDto pageableDto = new PageableDto();
        pageableDto.setCurrentPage(page);
        pageableDto.setTotalCount(totalCount);
        return pageableDto;
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
