package com.solution.blog.domain.search.client;

import com.solution.blog.domain.search.controller.model.SortType;
import com.solution.naver.domain.client.NaverClient;
import com.solution.naver.domain.model.NaverBlogRs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NaverClientTest {

    @Autowired
    private NaverClient naverClient;

    // 성공적으로 naver blog 검색
    @Test
    public void requirementTest() throws Exception {
        // given
        String keyword = "123";
        String sortType = SortType.RECENCY.getNaverName();
        Integer page = 1;
        Integer size = 10;

        // when
        // then
        NaverBlogRs daumBlogRs = naverClient.getNaverBlogRs(keyword, null, null, null);

        Assertions.assertEquals(daumBlogRs.getSuccessYn(), Boolean.TRUE);
    }

}