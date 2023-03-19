package com.solution.blog.repository;

import com.solution.blog.domain.search.entity.BlogSearchWordLog;
import org.springframework.data.repository.CrudRepository;

public interface BlogSearchWordLogRepository extends CrudRepository<BlogSearchWordLog, Long>, BlogSearchWordLogRepositoryCustom {
}
