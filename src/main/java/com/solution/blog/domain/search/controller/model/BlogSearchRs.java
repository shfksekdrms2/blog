package com.solution.blog.domain.search.controller.model;

import com.solution.blog.domain.page.PageableDto;
import com.solution.blog.domain.page.PageableRs;
import com.solution.blog.domain.search.component.model.DaumBlogDocumentDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class BlogSearchRs extends PageableRs {

    @Schema(description = "내용")
    List<BlogSearchDto> documents;

    public static BlogSearchRs of(List<DaumBlogDocumentDto> documents, PageableDto pageableDto) {
        BlogSearchRs rs = new BlogSearchRs();
        rs.setDocuments(documents);
        rs.setPageInfo(pageableDto);
        return rs;
    }

    public void setDocuments(List<DaumBlogDocumentDto> documents) {
        this.documents =
                documents.stream()
                        .map(DaumBlogDocumentDto::of)
                        .collect(Collectors.toList());
    }

}
