package com.solution.naver.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ItemDto {

    private String title;

    private String link;

    private String description;

    @JsonProperty(value = "bloggername")
    private String bloggerName;

    @JsonProperty(value = "bloggerlink")
    private String bloggerLink;

    @JsonProperty(value = "postdate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
    private LocalDate postDate;

}
