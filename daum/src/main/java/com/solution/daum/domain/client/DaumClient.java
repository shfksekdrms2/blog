package com.solution.daum.domain.client;

import com.solution.daum.domain.model.DaumBlogDocumentDto;
import com.solution.daum.domain.model.DaumBlogRs;
import domain.solution.core.model.controller.BlogSearchDto;
import domain.solution.core.model.controller.BlogSearchRs;
import domain.solution.core.search.FindBlogInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DaumClient implements FindBlogInterface {

    private final WebClient webClient;

    private final String REST_API_KEY = "408848115a7af9b9806f8b2d9a0666a0";

    @Override
    public BlogSearchRs findBlog(BlogSearchRs rs, String keyword, String sortType, PageRequest pageRequest) {
        if (rs.getSuccessYn()) {
            return rs;
        }

        try {
            UriComponents uriComponents = getUriComponents(keyword, sortType, pageRequest.getPageNumber(), pageRequest.getPageSize());
            DaumBlogRs daumBlogRs = webClient.get()
                    .uri(uriComponents.toUri())
                    .header(HttpHeaders.AUTHORIZATION, "KakaoAK " + REST_API_KEY)
                    .retrieve()
                    .bodyToMono(DaumBlogRs.class)
                    .block();

            // page 설정
            PageImpl<BlogSearchDto> daumBlogDocumentPage = getDaumBlogDocumentPage(daumBlogRs, pageRequest);
            return BlogSearchRs.of(daumBlogDocumentPage);
        } catch (WebClientException webClientException) {
            return new BlogSearchRs();
        }
    }

    private PageImpl<BlogSearchDto> getDaumBlogDocumentPage(DaumBlogRs daumBlogRs, PageRequest pageRequest) {
        List<BlogSearchDto> blogSearchDtoList = changeDocuments(daumBlogRs.getDocuments());
        return new PageImpl<>(blogSearchDtoList, pageRequest, daumBlogRs.getMeta().getTotalCount());
    }

    public List<BlogSearchDto> changeDocuments(List<DaumBlogDocumentDto> documents) {
        return documents.stream()
                .map(DaumBlogDocumentDto::of)
                .collect(Collectors.toList());
    }

    public UriComponents getUriComponents(String keyword, String sortType, Integer page, Integer size) {
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("dapi.kakao.com")
                .path("/v2/search/blog")
                .queryParam("sort", sortType)
                .queryParam("page", page)
                .queryParam("size", size)
                .queryParam("query", keyword)
                .build();
    }

}
