package com.solution.blog.domain.search.service;

import com.solution.blog.domain.search.repository.BlogPopularSearchWordLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BlogPopularSearchWordService {

    private final BlogPopularSearchWordLogRepository blogPopularSearchWordLogRepository;


}
