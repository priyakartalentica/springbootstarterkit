package com.mysql.publicationmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="users")
public class UserRegistration{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId ;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private Date createdOn;
    @Column
    private Date updatedOn;

    @OneToMany
    private List<Article> article;

    @OneToOne
    private Profile profile;



}
