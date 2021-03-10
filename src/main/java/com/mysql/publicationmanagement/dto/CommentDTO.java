package com.mysql.publicationmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

    private Long articleID;
    private String comment;
    private Long userID;
    private Long commentID;

    public boolean isValid() {
        boolean result=false;
        if(comment!=null && userID!=null && articleID!=null)
            result= true;
        return result;
    }
    //private Long userID;

}
