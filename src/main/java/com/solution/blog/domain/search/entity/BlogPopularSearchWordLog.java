package com.solution.blog.domain.search.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class BlogPopularSearchWordLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sn;

    private String keyword;

    private LocalDateTime createdDateTime;

}
