package com.solution.naver.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class NaverBlogRs {

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
//    private LocalDateTime lastBuildDate;

    private Integer total;

    private Integer start;

    private Integer display;

    private List<ItemDto> items;
}
