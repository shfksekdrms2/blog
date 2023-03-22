package com.solution.blog.domain.search.component;

import com.solution.blog.domain.search.controller.model.SortType;
import com.solution.blog.domain.search.service.BlogSearchWordService;
import com.solution.daum.domain.client.DaumClient;
import com.solution.naver.domain.client.NaverClient;
import domain.solution.core.model.controller.BlogSearchRs;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BlogComponent {

    private final DaumClient daumClient;
    private final NaverClient naverClient;

    private final BlogSearchWordService blogSearchWordService;

    public BlogSearchRs searchBlog(String keyword, SortType sortType, Integer page, Integer size) {

        // 키워드 검색 로그 저장
        blogSearchWordService.create(keyword);

        BlogSearchRs rs = new BlogSearchRs();
        PageRequest pageRequest = PageRequest.of(page, size);
        // 초기화
        rs.setPageInfo(pageRequest);
        rs = getBlogSearchRs(keyword, sortType, rs, pageRequest);

        return rs;
    }

    /**
     * find 순서 대로 찾기
     * daum -> naver 추가
     **/
    private BlogSearchRs getBlogSearchRs(String keyword, SortType sortType, BlogSearchRs rs, PageRequest pageRequest) {
        // daum blog open api
        rs = daumClient.findBlog(rs, keyword, sortType.getDaumName(), pageRequest);

        // naver blog open api
        rs = naverClient.findBlog(rs, keyword, sortType.getNaverName(), pageRequest);
        return rs;
    }
}
