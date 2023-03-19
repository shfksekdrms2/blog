package com.solution.blog.domain.page;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Setter
@Getter
public class PageableDto {

    @Schema(description = "현재 페이지")
    private Integer currentPage;

    @Schema(defaultValue = "페이지 당 게시물 수")
    private Integer size;

    @Schema(defaultValue = "총 페이지")
    private Integer totalPage;

    @Schema(description = "검색된 문서 수")
    private Long totalCount;

    public PageableDto(Page<?> page) {
        this.currentPage = page.getPageable().getPageNumber();
        this.size = page.getPageable().getPageSize();
        this.totalPage = page.getTotalPages();
        this.totalCount = page.getTotalElements();
    }

}
