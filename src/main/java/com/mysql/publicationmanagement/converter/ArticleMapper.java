package com.mysql.publicationmanagement.converter;

import com.mysql.publicationmanagement.model.Article;
import com.mysql.publicationmanagement.dto.ArticleDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

//@Mapper(componentModel = "spring")
public interface ArticleMapper {
  //ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

   //@Mapping(source = "title", target = "title")
   //@Mapping(source = "description", target = "description")
   //@Mapping(source = "body", target = "body")
   //@Mapping(source = "author", target = "author")
   ArticleDTO articleToArticleDTO(Article article);

   //@Mapping(source = "title", target = "title")
   //@Mapping(source = "description", target = "description")
   //@Mapping(source = "body", target = "body")
   //@Mapping(source = "author", target = "author")
   Article articleDTOToArticle(ArticleDTO articleDTO);

    List<ArticleDTO> articleListToArticleDTOList(List<Article> article);

    List<Article> ArticleDTOListToArticleList(List<ArticleDTO> articleDTO);

}
