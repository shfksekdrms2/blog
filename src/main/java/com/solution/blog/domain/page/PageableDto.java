package com.solution.blog.domain.page;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageableDto {

    @Schema(description = "현재 페이지")
    private Integer currentPage;

    @Schema(description = "검색된 문서 수")
    private Integer totalCount;

    public static PageableDto of(Integer currentPage, Integer totalCount) {
        PageableDto dto = new PageableDto();
        dto.setCurrentPage(currentPage);
        dto.setTotalCount(totalCount);
        return dto;
    }
}
