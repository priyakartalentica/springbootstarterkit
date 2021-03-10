package com.mysql.publicationmanagement.service;

import com.mysql.publicationmanagement.dto.ArticleDTO;

import java.util.List;

public interface ArticleService {
    List<ArticleDTO> getAllArticles();
    ArticleDTO getArticleById(Long  id);
    ArticleDTO createArticle(ArticleDTO  articleDTO);
    ArticleDTO updateArticle( Long  id, ArticleDTO articleDTO);
    void deleteArticle(Long id);

}
