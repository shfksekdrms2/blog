package com.solution.blog.domain.search.service;

import com.solution.blog.domain.search.controller.model.BlogPopularKeywordDto;
import com.solution.blog.domain.search.controller.model.BlogPopularKeywordRs;
import com.solution.blog.domain.search.entity.BlogSearchWordLog;
import com.solution.blog.repository.BlogSearchWordLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BlogSearchWordService {

    private final BlogSearchWordLogRepository blogSearchWordLogRepository;

    @Transactional
    public void create(String keyword) {
        BlogSearchWordLog blogSearchWordLog = BlogSearchWordLog.create(keyword);
        blogSearchWordLogRepository.save(blogSearchWordLog);
    }

    public BlogPopularKeywordRs findBlogPopularKeyword() {
        List<BlogPopularKeywordDto> popularKeywordTopTenList = blogSearchWordLogRepository.findPopularKeywordTopTen();
        BlogPopularKeywordRs rs = new BlogPopularKeywordRs();
        rs.setPopularKeywordTopTenList(popularKeywordTopTenList);
        return rs;
    }
}
