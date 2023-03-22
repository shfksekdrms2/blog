package domain.solution.core.model.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import domain.solution.core.model.page.PageableRs;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class BlogSearchRs extends PageableRs {

    @JsonIgnore
    private Boolean successYn = Boolean.FALSE;

    @Schema(description = "내용")
    List<BlogSearchDto> documents = new ArrayList<>();

    public static BlogSearchRs of(PageImpl<BlogSearchDto> blogSearchDtos) {
        BlogSearchRs rs = new BlogSearchRs();
        rs.setDocuments(blogSearchDtos.getContent());
        rs.setPageInfo(blogSearchDtos);
        rs.setSuccessYn(Boolean.TRUE);
        return rs;
    }
}
