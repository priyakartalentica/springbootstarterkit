package com.mysql.publicationmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String body;
    @Column
    private Date createdOn;
    @Column
    private Date updatedOn;
    @Column
    private String author;
    @Column
    private Long favoriteCount;

    @ManyToOne
    private UserRegistration user;

    @OneToMany
    private List<Comment> comments;

    @ManyToMany (mappedBy = "articles")
    private List<Tag> tags;


}