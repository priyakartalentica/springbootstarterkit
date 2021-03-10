package com.mysql.publicationmanagement.repositories;

import com.mysql.publicationmanagement.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository  extends JpaRepository<Article,Long> {
}
