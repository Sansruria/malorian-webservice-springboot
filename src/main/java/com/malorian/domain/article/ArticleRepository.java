package com.malorian.domain.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("SELECT p FROM Article p ORDER BY p.id DESC")
    List<Article> findAllDesc();

}
