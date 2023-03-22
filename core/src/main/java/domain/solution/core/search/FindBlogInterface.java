package domain.solution.core.search;

import domain.solution.core.model.controller.BlogSearchRs;
import org.springframework.data.domain.PageRequest;

public interface FindBlogInterface {
    BlogSearchRs findBlog(BlogSearchRs rs,
                          String keyword,
                          String sortType,
                          PageRequest pageRequest);
}
