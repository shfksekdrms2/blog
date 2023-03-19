package com.solution.blog.domain.search.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"블로그 검색"})
@RestController
@RequiredArgsConstructor
public class BlogSearchController {

    @Operation(summary = "블로그 검색을 위한 메소드",
            description = "키워드 검색, 정확도/최신순 검색, pagination, 다음 -> 네이버 검색순")
    @GetMapping("/search")
    public void search(@RequestParam(value = "keyword") String keyword) {

    }
}
