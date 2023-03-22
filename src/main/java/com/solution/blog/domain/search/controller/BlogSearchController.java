package com.solution.blog.domain.search.controller;

import com.solution.blog.domain.search.component.BlogComponent;
import domain.solution.core.model.controller.BlogSearchRs;
import com.solution.blog.domain.search.controller.model.SortType;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Api(tags = {"블로그 검색"})
@Validated
@RestController
@RequiredArgsConstructor
public class BlogSearchController {

    private final BlogComponent blogComponent;

    @Operation(summary = "블로그 검색을 위한 메소드",
            description = "키워드 검색, \n\n" +
                    "정확도/최신순 검색, \n\n" +
                    "pagination, \n\n" +
                    "다음 -> 네이버 검색순")
    @GetMapping("/blog/search")
    public BlogSearchRs search(@RequestParam(value = "keyword")
                               @NotBlank String keyword,
                               @RequestParam(value = "sortType", required = false, defaultValue = "ACCURACY") SortType sortType,
                               @RequestParam(value = "page", required = false, defaultValue = "1")
                               @Min(1) @Max(50) Integer page,
                               @RequestParam(value = "size", required = false, defaultValue = "10")
                               @Min(1) @Max(50) Integer size) {
        return blogComponent.searchBlog(keyword, sortType, page, size);
    }

}
