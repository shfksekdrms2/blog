package com.solution.daum.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DaumBlogRs {

    private Boolean successYn = Boolean.TRUE;

    private DaumBlogMetaDto meta;

    private List<DaumBlogDocumentDto> documents;

}
