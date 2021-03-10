package com.mysql.publicationmanagement.serviceImpl;

import com.mysql.publicationmanagement.converter.FavoriteMapper;
import com.mysql.publicationmanagement.converterImpl.FavoriteMapperImpl;
import com.mysql.publicationmanagement.dto.FavoriteDTO;
import com.mysql.publicationmanagement.repositories.FavoriteRepository;
import com.mysql.publicationmanagement.service.FavoriteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;
    FavoriteMapper favoriteMapper;

    public FavoriteServiceImpl() {
        favoriteMapper=new FavoriteMapperImpl();

    }

    public List<FavoriteDTO> getAllFavorites(){
        return favoriteMapper.toFavoriteDTOList(favoriteRepository.findAll());
    }

    public List<FavoriteDTO> getAllFavoritesByArticleID(Long articleID){
        return favoriteMapper.toFavoriteDTOList(favoriteRepository.findByArticleArticleId(articleID));
    }

    public List<FavoriteDTO> getAllFavoritesByUserID(Long userID){
        return favoriteMapper.toFavoriteDTOList(favoriteRepository.findByUserUserId(userID));
    }

    public FavoriteDTO addFavorite(FavoriteDTO favoriteDTO){
        return favoriteMapper.favoriteToFavoriteDTO(
                favoriteRepository.saveAndFlush(favoriteMapper.favoriteDTOToFavorite(favoriteDTO)));
    }

    public void deleteFavorite(Long favoriteId){
        favoriteRepository.deleteById(favoriteId);
    }
}
