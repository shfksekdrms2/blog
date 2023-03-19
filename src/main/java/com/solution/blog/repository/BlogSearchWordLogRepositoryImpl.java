package com.solution.blog.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.solution.blog.domain.search.controller.model.BlogPopularKeywordDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.solution.blog.domain.search.entity.QBlogSearchWordLog.blogSearchWordLog;

@RequiredArgsConstructor
public class BlogSearchWordLogRepositoryImpl implements BlogSearchWordLogRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<BlogPopularKeywordDto> findPopularKeywordTopTen() {

        return jpaQueryFactory
                .select(
                        Projections.fields(
                                BlogPopularKeywordDto.class,
                                blogSearchWordLog.keyword.as("keyword"),
                                blogSearchWordLog.count().as("count")
                        )
                )
                .from(blogSearchWordLog)
                .groupBy(blogSearchWordLog.keyword)
                .orderBy(blogSearchWordLog.count().desc())
                .limit(10)
                .fetch();
    }

}
