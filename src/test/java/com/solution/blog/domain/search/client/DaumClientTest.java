package com.solution.blog.domain.search.client;

import com.solution.blog.domain.search.controller.model.SortType;
import com.solution.daum.domain.client.DaumClient;
import com.solution.daum.domain.model.DaumBlogRs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DaumClientTest {

    @Autowired
    private DaumClient daumClient;

    // 성공적으로 daum blog 검색
    @Test
    public void requirementTest() throws Exception {
        // given
        String keyword = "123";
        String sortType = SortType.RECENCY.getKakaoName();
        Integer page = 1;
        Integer size = 10;

        // when
        // then
        DaumBlogRs daumBlogRs = daumClient.getDaumBlogRs(keyword, sortType, page, size);

        Assertions.assertEquals(daumBlogRs.getSuccessYn(), Boolean.TRUE);
    }

}