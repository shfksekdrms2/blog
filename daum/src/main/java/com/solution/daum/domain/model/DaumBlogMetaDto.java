package com.solution.daum.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DaumBlogMetaDto {
    @JsonProperty(value = "total_count")
    private Integer totalCount;

    @JsonProperty(value = "pageable_count")
    private Integer pageableCount;

    @JsonProperty(value = "is_end")
    private Boolean isEnd;
}
