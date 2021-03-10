package com.mysql.publicationmanagement.controller;

import com.mysql.publicationmanagement.dto.CommentDTO;
import com.mysql.publicationmanagement.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<CommentDTO> getallcomments(){
        return commentService.getAllComments();
    }

    @PostMapping
    public CommentDTO add(@RequestBody CommentDTO commentDTO){
        System.out.println("Inside create COmments controller add");

        return commentService.createComments(commentDTO);
    }

    @GetMapping
    @RequestMapping("{id}")
    public List<CommentDTO> getCommentsforArticle(@PathVariable Long id){
        return commentService.getCommentsForArticle(id);

    }


    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public CommentDTO update(@PathVariable Long id, @RequestBody CommentDTO commentDTO){
        return commentService.updateComment(id,commentDTO);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void deletecomment(@PathVariable Long id){
        commentService.deleteComment(id);
    }
}
