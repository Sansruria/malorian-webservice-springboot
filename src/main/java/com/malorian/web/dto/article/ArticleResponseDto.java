package com.malorian.web.dto.article;

import com.malorian.domain.article.Articles;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime modifiedDate;
    private int hit;

    public ArticleResponseDto(Articles entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
        this.hit = entity.getHit();
    }

}
