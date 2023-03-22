package domain.solution.core.model.page;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Setter
@Getter
public class PageableRs {
    private PageableDto pageInfo;

    public void setPageInfo(Page<?> page) {
        this.pageInfo = new PageableDto(page);
    }

    public void setPageInfo(PageRequest pageRequest) {
        this.pageInfo = new PageableDto(pageRequest);
    }
}
