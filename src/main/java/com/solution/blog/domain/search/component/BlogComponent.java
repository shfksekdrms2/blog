package com.solution.blog.domain.search.component;

import com.solution.blog.domain.search.controller.model.BlogSearchRs;
import com.solution.blog.domain.search.controller.model.SortType;
import com.solution.blog.domain.search.service.BlogSearchWordService;
import com.solution.daum.domain.client.DaumClient;
import com.solution.daum.domain.model.DaumBlogDocumentDto;
import com.solution.daum.domain.model.DaumBlogRs;
import com.solution.naver.domain.client.NaverClient;
import com.solution.naver.domain.model.ItemDto;
import com.solution.naver.domain.model.NaverBlogRs;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
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

        PageRequest pageRequest = PageRequest.of(page, size);
        // daum blog open api
        DaumBlogRs daumBlogRs = daumClient.getDaumBlogRs(keyword, sortType.getDaumName(), page, size);
        if (daumBlogRs.getSuccessYn()) {
            // page 설정
            PageImpl<DaumBlogDocumentDto> daumBlogDocumentPage = getDaumBlogDocumentPage(daumBlogRs, pageRequest);
            return BlogSearchRs.ofDaum(daumBlogDocumentPage);
        }

        // naver blog open api
        NaverBlogRs naverBlogRs = naverClient.getNaverBlogRs(keyword, sortType.getNaverName(), page, size);
        if (naverBlogRs.getSuccessYn()) {
            PageImpl<ItemDto> naverBlogDocumentPage = getNaverBlogDocumentPage(naverBlogRs, pageRequest);
            return BlogSearchRs.ofNaver(naverBlogDocumentPage);
        }

        // 초기화
        BlogSearchRs blogSearchRs = new BlogSearchRs();
        blogSearchRs.setPageInfo(pageRequest);
        return blogSearchRs;
    }

    private PageImpl<ItemDto> getNaverBlogDocumentPage(NaverBlogRs naverBlogRs, PageRequest pageRequest) {
        PageImpl<ItemDto> itemDtoPage = new PageImpl<>(naverBlogRs.getItems(), pageRequest, naverBlogRs.getTotal());
        return itemDtoPage;
    }

    private PageImpl<DaumBlogDocumentDto> getDaumBlogDocumentPage(DaumBlogRs daumBlogRs, PageRequest pageRequest) {
        PageImpl<DaumBlogDocumentDto> daumBlogDocumentDtoPage =
                new PageImpl<>(daumBlogRs.getDocuments(), pageRequest, daumBlogRs.getMeta().getTotalCount());
        return daumBlogDocumentDtoPage;
    }
}
