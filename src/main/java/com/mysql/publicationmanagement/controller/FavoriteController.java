package com.mysql.publicationmanagement.controller;

import com.mysql.publicationmanagement.dto.FavoriteDTO;
import com.mysql.publicationmanagement.service.FavoriteService;
import com.mysql.publicationmanagement.serviceImpl.FavoriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    public FavoriteController() {
        favoriteService=new FavoriteServiceImpl();
    }


    @GetMapping
    public List<FavoriteDTO> getAllComments(){
        return favoriteService.getAllFavorites();
    }

    @GetMapping
    @RequestMapping(path= "/article/{Id}")
    public  List<FavoriteDTO> getCommentsByArticle(@PathVariable Long Id){
        return favoriteService.getAllFavoritesByArticleID(Id);
    }


    @GetMapping
    @RequestMapping(path= "/user/{Id}")
    public List<FavoriteDTO> getCommentsByUser(@PathVariable Long Id){
        return favoriteService.getAllFavoritesByUserID(Id);
    }


    @PostMapping
    public FavoriteDTO createFavorite(@RequestBody FavoriteDTO favoriteDTO){
        return favoriteService.addFavorite(favoriteDTO);
    }


    @RequestMapping(value = "{Id}",method = RequestMethod.DELETE)
    public void deleteFavorite(@PathVariable Long Id){
        favoriteService.deleteFavorite(Id);
    }
}
