package com.solution.blog.domain.search.controller.model;

import com.solution.daum.domain.model.DaumBlogDocumentDto;
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

    public static BlogSearchDto of(DaumBlogDocumentDto daumBlogDocumentDto) {
        BlogSearchDto dto = new BlogSearchDto();
        dto.setTitle(daumBlogDocumentDto.getTitle());
        dto.setContents(daumBlogDocumentDto.getContents());
        dto.setUrl(daumBlogDocumentDto.getUrl());
        dto.setBlogName(daumBlogDocumentDto.getBlogName());
        dto.setThumbnail(daumBlogDocumentDto.getThumbnail());
        dto.setDatetime(daumBlogDocumentDto.getDatetime());

        return dto;
    }
}
