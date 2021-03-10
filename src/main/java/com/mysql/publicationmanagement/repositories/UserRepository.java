package com.mysql.publicationmanagement.repositories;

import com.mysql.publicationmanagement.model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserRegistration,Long> {
}
