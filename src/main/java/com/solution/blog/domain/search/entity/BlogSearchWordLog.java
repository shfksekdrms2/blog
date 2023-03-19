package com.solution.blog.domain.search.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BlogSearchWordLog extends CreatedDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sn;

    private String keyword; // 검색 키워드

    public static BlogSearchWordLog create(String keyword) {
        BlogSearchWordLog log = new BlogSearchWordLog();
        log.keyword = keyword;
        return log;
    }
}
