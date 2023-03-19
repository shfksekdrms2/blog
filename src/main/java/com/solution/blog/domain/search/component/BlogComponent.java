package com.solution.blog.domain.search.component;

import com.solution.blog.domain.search.controller.model.BlogSearchRs;
import com.solution.blog.domain.search.controller.model.SortType;
import com.solution.blog.domain.search.service.BlogSearchWordService;
import com.solution.daum.domain.client.DaumClient;
import com.solution.daum.domain.model.DaumBlogDocumentDto;
import com.solution.daum.domain.model.DaumBlogRs;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BlogComponent {

    private final DaumClient daumClient;

    private final BlogSearchWordService blogSearchWordService;

    public BlogSearchRs searchBlog(String keyword, SortType sortType, Integer page, Integer size) {

        // daum blog open api
        // todo 예외 처리 필요
        DaumBlogRs daumBlogRs = daumClient.getDaumBlogRs(keyword, sortType.getKakaoName(), page, size);

        // 키워드 검색 로그 저장
        blogSearchWordService.create(keyword);

        // page 설정
        PageImpl<DaumBlogDocumentDto> daumBlogDocumentPage = getDaumBlogDocumentPage(page, size, daumBlogRs);
        return BlogSearchRs.of(daumBlogDocumentPage);
    }

    private PageImpl<DaumBlogDocumentDto> getDaumBlogDocumentPage(Integer page, Integer size, DaumBlogRs daumBlogRs) {
        PageRequest pageRequest = PageRequest.of(page, size);
        PageImpl<DaumBlogDocumentDto> daumBlogDocumentDtoPage =
                new PageImpl<>(daumBlogRs.getDocuments(), pageRequest, daumBlogRs.getMeta().getTotalCount());
        return daumBlogDocumentDtoPage;
    }
}
