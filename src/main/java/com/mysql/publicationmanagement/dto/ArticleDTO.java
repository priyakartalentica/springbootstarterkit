package com.mysql.publicationmanagement.dto;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {


    private String title ;
    private String description;
    private String body;
    private String author;
    private Long articleID;

    //private Long userId;
    //private ArrayList<String> tags;


}
