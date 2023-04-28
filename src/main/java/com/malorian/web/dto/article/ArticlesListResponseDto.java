package com.malorian.web.dto.article;

import com.malorian.domain.article.Articles;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticlesListResponseDto {

    private Long id;
    private String title;
    private String author;
    private LocalDateTime createDate;
    private int hit;

    public ArticlesListResponseDto(Articles entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.createDate = entity.getCreateDate();
        this.hit = entity.getHit();
    }
}
