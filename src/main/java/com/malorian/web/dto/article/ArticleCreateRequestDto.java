package com.malorian.web.dto.article;

import com.malorian.domain.article.Article;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ArticleCreateRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public ArticleCreateRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Article toEntity() {
        return Article.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
