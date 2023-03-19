package com.solution.blog.domain.search.controller.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BlogPopularKeywordDto {

    private String keyword;

    private Long count;

}
