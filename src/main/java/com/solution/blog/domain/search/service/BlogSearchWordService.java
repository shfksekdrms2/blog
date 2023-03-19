package com.solution.blog.domain.search.service;

import com.solution.blog.domain.search.entity.BlogSearchWordLog;
import com.solution.blog.domain.search.repository.BlogSearchWordLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
