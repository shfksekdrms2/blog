package com.solution.naver.domain.client;

import com.solution.naver.domain.model.NaverBlogRs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class NaverClient {

    private final WebClient webClient;

    private final String X_NAVER_CLIENT_ID_HEADER = "X-Naver-Client-Id";
    private final String X_NAVER_CLIENT_ID_VALUE = "4TPmPdXYD1O0OuM8Lwr3";

    private final String X_NAVER_CLIENT_SECRET_HEADER = "X-Naver-Client-Secret";
    private final String X_NAVER_CLIENT_SECRET_VALUE = "wL7GYUsR13";

    public NaverBlogRs getNaverBlogRs(String keyword, String sortType, Integer page, Integer size) {
        UriComponents uriComponents = getUriComponents(keyword, sortType, page, size);
        NaverBlogRs naverBlogRs;
        try {
            naverBlogRs = webClient.get()
                    .uri(uriComponents.toUri())
                    .header(X_NAVER_CLIENT_ID_HEADER, X_NAVER_CLIENT_ID_VALUE)
                    .header(X_NAVER_CLIENT_SECRET_HEADER, X_NAVER_CLIENT_SECRET_VALUE)
                    .retrieve()
                    .bodyToMono(NaverBlogRs.class)
                    .block();
        } catch (WebClientException webClientException) {
            naverBlogRs = new NaverBlogRs();
            naverBlogRs.setSuccessYn(Boolean.FALSE);
        }
        return naverBlogRs;
    }

    public UriComponents getUriComponents(String keyword, String sortType, Integer page, Integer size) {
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("openapi.naver.com")
                .path("/v1/search/blog.json")
                .queryParam("sort", sortType)
                .queryParam("start", page)
                .queryParam("display", size)
                .queryParam("query", keyword)
                .build();
    }
}
