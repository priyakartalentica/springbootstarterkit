package com.mysql.publicationmanagement.service;

import com.mysql.publicationmanagement.converter.CommentMapper;
import com.mysql.publicationmanagement.dto.CommentDTO;
import com.mysql.publicationmanagement.model.Comment;
import org.springframework.beans.BeanUtils;

import java.util.List;

public interface CommentService {

    List<CommentDTO> getAllComments();
    CommentDTO createComments(CommentDTO commentDTO);
    List<CommentDTO> getCommentsForArticle( Long id);
    CommentDTO updateComment( Long id, CommentDTO commentDTO);
    void deleteComment(Long id);

}
