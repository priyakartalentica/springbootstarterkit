package com.mysql.publicationmanagement.dto;

import lombok.Data;

@Data
public class FavoriteDTO {
    private Long articleID;
    private Long userID;
    private Long favoriteID;

}
