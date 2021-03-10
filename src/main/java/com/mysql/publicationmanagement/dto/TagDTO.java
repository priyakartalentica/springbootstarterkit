package com.mysql.publicationmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagDTO {

    private Long tagId;

    private String tagName;

    private List<Long> articleID;

    public TagDTO(Long tagId, String tagName) {
        this.tagId=tagId;
        this.tagName=tagName;
    }
}
