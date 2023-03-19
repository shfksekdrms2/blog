package com.solution.blog.domain.search.component.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DaumBlogRs {

    private DaumBlogMetaDto meta;

    private List<DaumBlogDocumentDto> documents;

}
