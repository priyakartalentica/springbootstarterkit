package com.mysql.publicationmanagement.repositories;

import com.mysql.publicationmanagement.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByArticleArticleId(Long articleId);

    List<Favorite> findByUserUserId(Long userId);
}
