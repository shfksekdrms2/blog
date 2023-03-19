package com.solution.blog.domain.search.controller;

import com.solution.blog.domain.search.controller.model.BlogPopularKeywordRs;
import com.solution.blog.domain.search.service.BlogSearchWordService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"블로그 인기 검색어 목록"})
@RestController
@RequiredArgsConstructor
public class BlogPopularSearchWordController {

    private final BlogSearchWordService blogSearchWordService;

    @Operation(summary = "블로그 인기 검색어 검색을 위한 메소드",
            description = "사용자들이 많이 검색한 순서대로, 최대 10개의 검색 키워드를 제공 \n\n" +
                    "검색어 별로 검색된 횟수도 함께 표기")
    @GetMapping("/blog/popular/keyword")
    public BlogPopularKeywordRs findBlogPopularKeyword() {
        return blogSearchWordService.findBlogPopularKeyword();
    }

}
