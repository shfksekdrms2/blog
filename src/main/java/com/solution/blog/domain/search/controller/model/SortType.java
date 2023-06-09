package com.solution.blog.domain.search.controller.model;

import lombok.Getter;

@Getter
public enum SortType {
    ACCURACY("정확도", "accuracy", "sim"),
    RECENCY("최신순", "recency", "date");

    private final String name;
    private final String daumName;
    private final String naverName;

    SortType(String name, String daumName, String naverName) {
        this.name = name;
        this.daumName = daumName;
        this.naverName = naverName;
    }
}
