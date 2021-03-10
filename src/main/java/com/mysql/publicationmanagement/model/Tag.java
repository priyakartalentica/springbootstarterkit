package com.mysql.publicationmanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name="tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @Column private String tagName;

   @ManyToMany
   @JoinTable(
           name="tag_article",
           joinColumns=@JoinColumn(name="tagId"),
           inverseJoinColumns=@JoinColumn(name="articleId")
   )
   private List<Article> articles;
}
