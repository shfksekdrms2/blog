package com.solution.blog.domain.search.repository;

import com.solution.blog.domain.search.entity.BlogPopularSearchWordLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPopularSearchWordLogRepository extends JpaRepository<BlogPopularSearchWordLog, Long> {
}
