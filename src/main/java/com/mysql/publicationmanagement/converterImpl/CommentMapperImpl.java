package com.mysql.publicationmanagement.converterImpl;

import com.mysql.publicationmanagement.converter.CommentMapper;
import com.mysql.publicationmanagement.dto.CommentDTO;
import com.mysql.publicationmanagement.model.Article;
import com.mysql.publicationmanagement.model.Comment;
import com.mysql.publicationmanagement.model.UserRegistration;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class CommentMapperImpl implements CommentMapper {

    public CommentDTO toCommentDTO(Comment comment){
        CommentDTO commentDTO= new CommentDTO();
        commentDTO.setArticleID(comment.getArticle().getArticleId());
        commentDTO.setComment(comment.getComment());
        commentDTO.setCommentID(comment.getCommentId());
        commentDTO.setUserID(comment.getUser().getUserId());
        return  commentDTO;
    }

    public Comment toComment(CommentDTO commentDTO){
        Comment comment=new Comment();
        Article article=new Article();
        article.setArticleId(commentDTO.getArticleID());
        comment.setArticle(article);
        comment.setComment(commentDTO.getComment());
        comment.setCommentId(commentDTO.getCommentID());
        UserRegistration user=new UserRegistration();
        user.setUserId(commentDTO.getUserID());
        comment.setUser(user);
        return  comment;
    }
    public List<CommentDTO> toCommentDTOList(List<Comment> commentList){
        List<CommentDTO> dtoList=new ArrayList<>();
        for (Comment comment :commentList) {
            dtoList.add(toCommentDTO(comment));
        }
        return dtoList;
    }
    public List<Comment> toCommentList(List<CommentDTO> commentDTOList){
        List<Comment> commentList=new ArrayList<>();
        for (CommentDTO dto :commentDTOList) {
            commentList.add(toComment(dto));
        }
        return commentList;
    }
}
