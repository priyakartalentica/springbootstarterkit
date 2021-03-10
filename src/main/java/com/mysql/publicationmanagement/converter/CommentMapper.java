package com.mysql.publicationmanagement.converter;

import com.mysql.publicationmanagement.model.Comment;
import com.mysql.publicationmanagement.dto.CommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
//@Mapper(componentModel = "spring")
public interface CommentMapper {
    //CommentMapper INSTANCE = Mappers.getMapper( CommentMapper.class );
    //@Mapping(source = "user.userID", target = "userID")
    //@Mapping(source = "article.articleID", target = "articleID")
    CommentDTO toCommentDTO(Comment comment);
    //@Mapping(source = "userID", target = "user.userID")
    //@Mapping(source = "articleID", target = "article.articleID")
    Comment toComment(CommentDTO commentDTO);
    List<CommentDTO> toCommentDTOList(List<Comment> comment);
    List<Comment> toCommentList(List<CommentDTO> commentDTO);
}
