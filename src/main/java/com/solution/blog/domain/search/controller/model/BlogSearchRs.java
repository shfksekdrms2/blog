package com.solution.blog.domain.search.controller.model;

import com.solution.blog.domain.page.PageableRs;
import com.solution.daum.domain.model.DaumBlogDocumentDto;
import com.solution.naver.domain.model.ItemDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class BlogSearchRs extends PageableRs {

    @Schema(description = "내용")
    List<BlogSearchDto> documents;

    public static BlogSearchRs ofDaum(PageImpl<DaumBlogDocumentDto> daumBlogDocumentDtoPage) {
        BlogSearchRs rs = new BlogSearchRs();
        rs.setDocuments(daumBlogDocumentDtoPage.getContent());
        rs.setPageInfo(daumBlogDocumentDtoPage);
        return rs;
    }

    public static BlogSearchRs ofNaver(PageImpl<ItemDto> naverBlogDocumentPage) {
        BlogSearchRs rs = new BlogSearchRs();
        rs.setDocumentsByName(naverBlogDocumentPage.getContent());
        rs.setPageInfo(naverBlogDocumentPage);
        return rs;
    }

    public void setDocumentsByName(List<ItemDto> documents) {
        this.documents =
                documents.stream()
                        .map(BlogSearchDto::of)
                        .collect(Collectors.toList());
    }

    public void setDocuments(List<DaumBlogDocumentDto> documents) {
        this.documents =
                documents.stream()
                        .map(BlogSearchDto::of)
                        .collect(Collectors.toList());
    }

}
