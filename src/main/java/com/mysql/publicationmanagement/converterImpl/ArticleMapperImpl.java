package com.mysql.publicationmanagement.converterImpl;

import com.mysql.publicationmanagement.converter.ArticleMapper;
import com.mysql.publicationmanagement.dto.ArticleDTO;
import com.mysql.publicationmanagement.model.Article;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class ArticleMapperImpl implements ArticleMapper {

     public ArticleDTO articleToArticleDTO(Article article){
        ArticleDTO dto= new ArticleDTO();
        dto.setTitle(article.getTitle());
        dto.setDescription(article.getDescription());
        dto.setBody(article.getBody());
        dto.setAuthor(article.getAuthor());
        if(article.getArticleId()!=null){
            dto.setArticleID(article.getArticleId());
        }
        return dto;
    }

    public Article articleDTOToArticle(ArticleDTO dto){
        Article article= new Article();
        article.setTitle(dto.getTitle());
        article.setDescription(dto.getDescription());
        article.setBody(dto.getBody());
        article.setAuthor(dto.getAuthor());
        if(dto.getArticleID()!=null) {
            article.setArticleId(dto.getArticleID());
        }
        return article;
    }

    public List<ArticleDTO> articleListToArticleDTOList(List<Article> articles) {
        List<ArticleDTO> dtoList=new ArrayList<>();
        for (Article article :articles) {
            dtoList.add(articleToArticleDTO(article));
        }
        return dtoList;

    }

    public List<Article> ArticleDTOListToArticleList(List<ArticleDTO> articleDTO){
        List<Article> articleList=new ArrayList<>();
        for (ArticleDTO dto :articleDTO) {
            articleList.add(articleDTOToArticle(dto));
        }
        return articleList;
    }

}
