package com.solution.blog.domain.page;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Setter
@Getter
public class PageableRs {
    private PageableDto pageInfo;

    public void setPageInfo(Page<?> page) {
        this.pageInfo = new PageableDto(page);
    }
}
