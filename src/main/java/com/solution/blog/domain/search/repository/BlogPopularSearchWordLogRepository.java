package com.solution.blog.domain.search.repository;

import com.solution.blog.domain.search.entity.BlogSearchWordLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPopularSearchWordLogRepository extends JpaRepository<BlogSearchWordLog, Long> {
}
