package com.solution.blog.domain.page;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageableDto {

    @Schema(description = "검색된 문서 수")
    private Integer totalCount;

    public static PageableDto of(Integer totalCount) {
        PageableDto dto = new PageableDto();
        dto.setTotalCount(totalCount);
        return dto;
    }
}
