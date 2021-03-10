package com.mysql.publicationmanagement.repositories;

import com.mysql.publicationmanagement.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
