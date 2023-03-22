package com.solution.blog.domain.search.client;

import com.solution.blog.domain.search.controller.model.SortType;
import com.solution.daum.domain.client.DaumClient;
import domain.solution.core.model.controller.BlogSearchRs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
class DaumClientTest {

    @Autowired
    private DaumClient daumClient;

    // 성공적으로 daum blog 검색
    @Test
    public void requirementTest() throws Exception {
        // given
        String keyword = "123";
        String sortType = SortType.RECENCY.getDaumName();
        Integer page = 1;
        Integer size = 10;

        BlogSearchRs rs = new BlogSearchRs();
        PageRequest pageRequest = PageRequest.of(page, size);
        // when
        // then
        BlogSearchRs blogSearchRs = daumClient.findBlog(rs, keyword, sortType, pageRequest);

        Assertions.assertEquals(blogSearchRs.getSuccessYn(), Boolean.TRUE);
    }

}