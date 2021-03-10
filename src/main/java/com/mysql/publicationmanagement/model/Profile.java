package com.mysql.publicationmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data

@AllArgsConstructor
@Entity(name="profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    @Column
    private String bioData;
    @Column
    private String image;
    @OneToOne
    private UserRegistration user;
    public Profile(){
        user=new UserRegistration();
    }

}
