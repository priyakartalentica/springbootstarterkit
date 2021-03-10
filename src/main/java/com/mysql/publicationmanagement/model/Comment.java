package com.mysql.publicationmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @Column
    private String comment;
    @Column
    private Date createdOn;
    @Column
    private Date updatedOn;


    @ManyToOne
    private Article article;

    @ManyToOne
    private UserRegistration user;


}
