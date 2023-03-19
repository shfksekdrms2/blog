package com.solution.blog.domain.search.controller.model;

import com.solution.daum.domain.model.DaumBlogDocumentDto;
import com.solution.naver.domain.model.ItemDto;
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

    public static BlogSearchDto of(ItemDto itemDto) {
        BlogSearchDto dto = new BlogSearchDto();
        dto.setTitle(itemDto.getTitle());
        dto.setContents(itemDto.getDescription());
        dto.setUrl(itemDto.getLink());
        dto.setBlogName(itemDto.getBloggerName());
        dto.setThumbnail("");
        dto.setDatetime(itemDto.getPostDate().atTime(0, 0));

        return dto;
    }
}
