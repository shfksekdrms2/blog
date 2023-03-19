package com.solution.blog.domain.search.controller.model;

import lombok.Getter;

@Getter
public enum SortType {
    ACCURACY("정확도", "accuracy"),
    RECENCY("최신순", "recency");

    private final String name;
    private final String kakaoName;

    SortType(String name, String kakaoName) {
        this.name = name;
        this.kakaoName = kakaoName;
    }
}
