package com.mysql.publicationmanagement.controller;


import com.mysql.publicationmanagement.dto.TagDTO;
import com.mysql.publicationmanagement.service.TagService;
import com.mysql.publicationmanagement.serviceImpl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    public TagController() {
        tagService=new TagServiceImpl();
    }

    @GetMapping
    public List<TagDTO> getAllTags(){

        return tagService.getAllTags();
    }



    @GetMapping
    @RequestMapping("{id}")
    public TagDTO getoneUser(@PathVariable Long id){

        return tagService.getTagsByID(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TagDTO create(@RequestBody TagDTO userDTO){
        return tagService.createTag(userDTO);
    }



    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteuser(@PathVariable Long id){
        tagService.deleteTag(id);
    }

    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    public TagDTO updateUser(@PathVariable Long id, @RequestBody TagDTO userDTO){

        return tagService.updateTag(id, userDTO);
    }
}

