package com.solution.blog.domain.search.controller.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BlogPopularKeywordRs {
    private List<BlogPopularKeywordDto> popularKeywordTopTenList;
}
