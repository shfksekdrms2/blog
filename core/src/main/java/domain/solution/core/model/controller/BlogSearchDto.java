package domain.solution.core.model.controller;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class BlogSearchDto {

    private String title;

    private String contents;

    private String url;

    private String blogName;

    private String thumbnail;

    private LocalDateTime datetime;

}
