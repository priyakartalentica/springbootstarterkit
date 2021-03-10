package com.mysql.publicationmanagement.serviceImpl;

import com.mysql.publicationmanagement.converter.ArticleMapper;
import com.mysql.publicationmanagement.converterImpl.ArticleMapperImpl;
import com.mysql.publicationmanagement.dto.ArticleDTO;
import com.mysql.publicationmanagement.model.Article;
import com.mysql.publicationmanagement.repositories.ArticleRepository;
import com.mysql.publicationmanagement.service.ArticleService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@AllArgsConstructor

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    private ArticleMapper articleMapper;

    public ArticleServiceImpl() {

        articleMapper=new ArticleMapperImpl();
    }

    public List<ArticleDTO> getAllArticles(){
        List<Article> articleList= articleRepository.findAll();

        return articleMapper.articleListToArticleDTOList(articleList);

    }

    public ArticleDTO getArticleById(Long id){
        return articleMapper.articleToArticleDTO(articleRepository.getOne(id));
    }

    public ArticleDTO createArticle( ArticleDTO articleDTO){
        java.util.Date date=new java.util.Date();
        if(isvalid(articleDTO)) {
           Article article= articleMapper.articleDTOToArticle(articleDTO);
           article.setCreatedOn(date);
           article.setUpdatedOn(date);
            System.out.println("created Article");
           return articleMapper.articleToArticleDTO(articleRepository.saveAndFlush(article));

       }
       else{
           System.out.println("did not create Artile");
           return new ArticleDTO();
       }
    }


    public ArticleDTO updateArticle(Long id,ArticleDTO articleDTO){
        if(isvalid(articleDTO)) {
            Article oldArticle = articleRepository.getOne(id);
            Article modifiedArticle= articleMapper.articleDTOToArticle(articleDTO);
            oldArticle.setBody(modifiedArticle.getBody());
            oldArticle.setTitle(modifiedArticle.getTitle());
            oldArticle.setDescription(modifiedArticle.getDescription());
            oldArticle.setAuthor(modifiedArticle.getAuthor());
            //BeanUtils.copyProperties(articleMapper.articleDTOToArticle(articleDTO), oldArticle);
            oldArticle.setUpdatedOn(new java.util.Date());
            System.out.println("updated Artile");
            return articleMapper.articleToArticleDTO(articleRepository.saveAndFlush(oldArticle));

        }else{
            Article oldArticle = articleRepository.getOne(id);
            System.out.println("did not Artile");
            return articleMapper.articleToArticleDTO(articleRepository.saveAndFlush(oldArticle));
        }
    }

    public void deleteArticle(Long id){
        if(articleRepository.getOne(id)!=null) {
            articleRepository.deleteById(id);
        }
    }

    public boolean isvalid(ArticleDTO dto){
        boolean result=true;

        if((dto.getTitle()==null || dto.getTitle()=="") || (dto.getBody()==null || dto.getBody()=="")) {
            result = false;

        }
        System.out.println("is validate"+result);
        return result;
    }
}
