package com.mysql.publicationmanagement.service;

import com.mysql.publicationmanagement.dto.TagDTO;

import java.util.List;

public interface TagService {
    List<TagDTO> getAllTags();

    TagDTO getTagsByID(Long id);

    TagDTO createTag(TagDTO userDTO);

    void deleteTag(Long id);

    TagDTO updateTag(Long id, TagDTO userDTO);
}
