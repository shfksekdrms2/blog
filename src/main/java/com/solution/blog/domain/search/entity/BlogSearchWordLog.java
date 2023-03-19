package com.solution.blog.domain.search.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Entity
public class BlogSearchWordLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sn;

    private String word; // 검색 키워드

    private LocalDateTime createdDateTime; // 생성 일시

}
