package com.mysql.publicationmanagement.converter;

import com.mysql.publicationmanagement.model.Favorite;
import com.mysql.publicationmanagement.dto.FavoriteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FavoriteMapper {
    FavoriteMapper INSTANCE = Mappers.getMapper( FavoriteMapper.class );

    FavoriteDTO favoriteToFavoriteDTO(Favorite favorite);
    Favorite favoriteDTOToFavorite(FavoriteDTO favoriteDTO);
    List<FavoriteDTO> toFavoriteDTOList(List<Favorite> favorite);
    List<Favorite> toFavoriteList(List<FavoriteDTO> favoriteDTO);
}
