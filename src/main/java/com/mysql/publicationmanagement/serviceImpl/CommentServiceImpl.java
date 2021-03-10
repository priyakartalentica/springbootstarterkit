package com.mysql.publicationmanagement.serviceImpl;
import com.mysql.publicationmanagement.converter.CommentMapper;
import com.mysql.publicationmanagement.converterImpl.CommentMapperImpl;
import com.mysql.publicationmanagement.dto.CommentDTO;
import com.mysql.publicationmanagement.model.Comment;
import com.mysql.publicationmanagement.repositories.CommentRepository;
import com.mysql.publicationmanagement.service.CommentService;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    //@Autowired
    private CommentMapperImpl commentMapper;

    public CommentServiceImpl() {
        commentMapper=new CommentMapperImpl();
    }

    public List<CommentDTO> getAllComments(){
        return commentMapper.toCommentDTOList(commentRepository.findAll());
    }


    public CommentDTO createComments(CommentDTO commentDTO){
        System.out.println("Inside create COmments service impl");
        if(commentDTO.isValid()) {
            Comment comment  =commentMapper.toComment(commentDTO); //CommentMapper.INSTANCE.toComment(commentDTO);
            comment.setCreatedOn(new java.util.Date());

            return commentMapper.toCommentDTO(commentRepository
                    .saveAndFlush(comment));
        }
        else {
            return new CommentDTO();
        }
    }

    public List<CommentDTO> getCommentsForArticle( Long id){
        return commentMapper.toCommentDTOList(commentRepository.getCommentsforArticle(id));

    }


    public CommentDTO updateComment( Long id, CommentDTO commentDTO){
        Comment oldcomment= commentRepository.getOne(id);
        Comment modifiedComment=commentMapper.toComment(commentDTO);
        oldcomment.setComment(modifiedComment.getComment());
        //BeanUtils.copyProperties(commentMapper.toComment(commentDTO),oldcomment);
        oldcomment.setUpdatedOn(new java.util.Date());
        System.out.println(" \n comment old : " + oldcomment.getComment()+ " new comment :"+ commentDTO.getComment() );
        return commentMapper.toCommentDTO(commentRepository.saveAndFlush(oldcomment));
    }


    public void deleteComment(Long id){
        commentRepository.deleteById(id);
    }
}
