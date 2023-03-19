package com.solution.blog.repository;

import com.solution.blog.domain.search.controller.model.BlogPopularKeywordDto;

import java.util.List;

public interface BlogSearchWordLogRepositoryCustom {
    List<BlogPopularKeywordDto> findPopularKeywordTopTen();
}
