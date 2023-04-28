package com.malorian.domain.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Articles, Long> {

    @Query("SELECT p FROM Articles p ORDER BY p.id DESC")
    List<Articles> findAllDesc();

    @Modifying
    @Query("UPDATE Articles p SET p.hit = p.hit + 1 WHERE p.id = :id")
    int viewAndHit(@Param("id") Long id);

}
