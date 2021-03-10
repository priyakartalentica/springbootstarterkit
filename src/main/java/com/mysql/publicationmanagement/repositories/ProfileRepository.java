package com.mysql.publicationmanagement.repositories;

import com.mysql.publicationmanagement.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProfileRepository extends JpaRepository<Profile,Long> {
}
