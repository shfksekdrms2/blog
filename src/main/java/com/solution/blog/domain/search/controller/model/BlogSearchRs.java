package com.solution.blog.domain.search.controller.model;

import com.solution.blog.domain.page.PageableDto;
import com.solution.blog.domain.page.PageableRs;
import com.solution.blog.domain.search.component.model.DaumBlogDocumentDto;
import com.solution.blog.domain.search.component.model.DaumBlogMetaDto;
import com.solution.blog.domain.search.component.model.DaumBlogRs;
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

    public static BlogSearchRs of(DaumBlogRs daumBlogRs) {
        BlogSearchRs rs = new BlogSearchRs();
        rs.setDocuments(daumBlogRs.getDocuments());

        DaumBlogMetaDto meta = daumBlogRs.getMeta();
        PageableDto pageableDto = PageableDto.of(meta.getTotalCount());
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
