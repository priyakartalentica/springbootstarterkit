package com.mysql.publicationmanagement.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name="favorite")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteId;

    @OneToOne
    private Article article;

    @OneToOne
    private UserRegistration user;

    //@OnetoOne
    //private  Article article;
    //@OneToOne
    //private List<User> user;
}
