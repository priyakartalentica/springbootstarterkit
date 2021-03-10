package com.mysql.publicationmanagement.service;

import com.mysql.publicationmanagement.dto.FavoriteDTO;
import com.mysql.publicationmanagement.repositories.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface FavoriteService {
    List<FavoriteDTO> getAllFavorites();
    List<FavoriteDTO> getAllFavoritesByArticleID(Long articleID);
    List<FavoriteDTO> getAllFavoritesByUserID(Long userID);
    FavoriteDTO addFavorite(FavoriteDTO favoriteDTO);
    void deleteFavorite(Long favoriteId);
}
