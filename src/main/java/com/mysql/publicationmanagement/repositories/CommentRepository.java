package com.mysql.publicationmanagement.repositories;

import com.mysql.publicationmanagement.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Query("select c from comment c where article_article_id =?1")
    List<Comment> getCommentsforArticle(Long id);
}
