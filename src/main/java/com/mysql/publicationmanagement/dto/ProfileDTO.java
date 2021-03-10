package com.mysql.publicationmanagement.dto;

import lombok.Data;

@Data
public class ProfileDTO {
    private Long userID;
    private String biodata;
    private String image;
    private Long profileId;
}
