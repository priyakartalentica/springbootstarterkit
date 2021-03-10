package com.mysql.publicationmanagement.converter;

import com.mysql.publicationmanagement.dto.TagDTO;
import com.mysql.publicationmanagement.model.Tag;

import java.util.List;

public interface TagMapper {
    List<TagDTO> toTagDTOList(List<Tag> all);

    TagDTO toTagDTO(Tag tag);

    Tag toTag(TagDTO userDTO);

    List<Tag> toTagList(List<TagDTO> userDTO);
}
