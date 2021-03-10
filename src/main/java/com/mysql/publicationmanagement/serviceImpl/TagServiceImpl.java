package com.mysql.publicationmanagement.serviceImpl;

import com.mysql.publicationmanagement.converter.TagMapper;
import com.mysql.publicationmanagement.converterImpl.TagMapperImpl;
import com.mysql.publicationmanagement.dto.TagDTO;
import com.mysql.publicationmanagement.model.Tag;
import com.mysql.publicationmanagement.repositories.TagRepository;
import com.mysql.publicationmanagement.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository tagRepository;
    TagMapper tagMapper;

    public TagServiceImpl() {
        tagMapper=new TagMapperImpl();
    }

    @Override
    public List<TagDTO> getAllTags() {
        return tagMapper.toTagDTOList(tagRepository.findAll());
    }

    @Override
    public TagDTO getTagsByID(Long id) {
        return tagMapper.toTagDTO(tagRepository.getOne(id));
    }

    @Override
    public TagDTO createTag(TagDTO userDTO) {
        return tagMapper.toTagDTO(tagRepository.saveAndFlush(tagMapper.toTag(userDTO)));
    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    public TagDTO updateTag(Long id, TagDTO userDTO) {
        Tag oldTag=tagRepository.getOne(id);
        Tag modifiedTag=tagMapper.toTag(userDTO);
        oldTag.setTagName(modifiedTag.getTagName());
        return tagMapper.toTagDTO(tagRepository.saveAndFlush(oldTag));
    }
}
