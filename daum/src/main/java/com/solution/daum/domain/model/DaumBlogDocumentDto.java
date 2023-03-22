package com.solution.daum.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import domain.solution.core.model.controller.BlogSearchDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class DaumBlogDocumentDto {

    @Schema(description = "블로그 글 제목")
    private String title;

    @Schema(description = "블로그 글 요약")
    private String contents;

    @Schema(description = "블로그 글 URL")
    private String url;

    @Schema(description = "블로그의 이름")
    @JsonProperty(value = "blogname")
    private String blogName;

    @Schema(description = "검색 시스템에서 추출한 대표 미리보기 이미지 URL, 미리보기 크기 및 화질은 변경될 수 있음")
    private String thumbnail;

    @Schema(description = "블로그 글 작성시간, ISO 8601 [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].000+[tz]")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
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
