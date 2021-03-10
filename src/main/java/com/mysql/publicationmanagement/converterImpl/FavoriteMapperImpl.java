package com.mysql.publicationmanagement.converterImpl;

import com.mysql.publicationmanagement.converter.FavoriteMapper;
import com.mysql.publicationmanagement.dto.FavoriteDTO;
import com.mysql.publicationmanagement.model.Article;
import com.mysql.publicationmanagement.model.Favorite;
import com.mysql.publicationmanagement.model.UserRegistration;

import java.util.ArrayList;
import java.util.List;

public class FavoriteMapperImpl implements FavoriteMapper {

    @Override
    public FavoriteDTO favoriteToFavoriteDTO(Favorite favorite) {
        FavoriteDTO favoriteDTO=new FavoriteDTO();
        favoriteDTO.setArticleID(favorite.getArticle().getArticleId());
        favoriteDTO.setFavoriteID(favorite.getFavoriteId());
        favoriteDTO.setUserID(favorite.getUser().getUserId());
        return favoriteDTO;
    }

    @Override
    public Favorite favoriteDTOToFavorite(FavoriteDTO favoriteDTO) {
        Favorite favorite=new Favorite();
        Article article=new Article();
        article.setArticleId(favoriteDTO.getArticleID());
        favorite.setArticle(article);
        favorite.setFavoriteId(favoriteDTO.getFavoriteID());
        UserRegistration user=new UserRegistration();
        user.setUserId(favoriteDTO.getUserID());
        favorite.setUser(user);
        return favorite;
    }

    @Override
    public List<FavoriteDTO> toFavoriteDTOList(List<Favorite> favoriteList) {
        List<FavoriteDTO> dtoList=new ArrayList<>();
        for (Favorite favorite :favoriteList) {
            dtoList.add(favoriteToFavoriteDTO(favorite));
        }
        return dtoList;
    }

    @Override
    public List<Favorite> toFavoriteList(List<FavoriteDTO> favoriteDTOList) {
        List<Favorite> favoriteList=new ArrayList<>();
        for(FavoriteDTO dto: favoriteDTOList){
            favoriteList.add(favoriteDTOToFavorite(dto));
        }
        return favoriteList;
    }
}
