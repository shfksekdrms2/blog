package com.solution.naver.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class NaverBlogRs {

    private Boolean successYn = Boolean.TRUE;

    private Integer total;

    private Integer start;

    private Integer display;

    private List<ItemDto> items;
}
