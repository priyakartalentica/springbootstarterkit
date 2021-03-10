package com.mysql.publicationmanagement.controller;


import com.mysql.publicationmanagement.dto.ArticleDTO;
import com.mysql.publicationmanagement.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<ArticleDTO> listAllArticle(){
        return articleService.getAllArticles();

    }

    @GetMapping
    @RequestMapping("{id}")
    public ArticleDTO get(@PathVariable Long id){
        return articleService.getArticleById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ArticleDTO create(@RequestBody ArticleDTO articleDTO){

        return articleService.createArticle(articleDTO);
    }

    @RequestMapping(value="{id}",method=RequestMethod.PUT)
    public ArticleDTO update( @PathVariable Long id, @RequestBody ArticleDTO articleDTO){
        return articleService.updateArticle(id,articleDTO);

    }

   @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        articleService.deleteArticle(id);
    }
}
