package com.solution.daum.domain.client;

import com.solution.daum.domain.model.DaumBlogRs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class DaumClient {

    private final WebClient webClient;

    private final String REST_API_KEY = "408848115a7af9b9806f8b2d9a0666a0";

    public DaumBlogRs getDaumBlogRs(String keyword, String sortType, Integer page, Integer size) {
        UriComponents uriComponents = getUriComponents(keyword, sortType, page, size);

        return webClient.get()
                .uri(uriComponents.toUri())
                .header(HttpHeaders.AUTHORIZATION, "KakaoAK " + REST_API_KEY)
                .retrieve()
                .bodyToMono(DaumBlogRs.class)
                .block();
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
