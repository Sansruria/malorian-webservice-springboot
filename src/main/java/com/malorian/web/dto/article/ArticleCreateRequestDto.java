package com.malorian.web.dto.article;

import com.malorian.domain.article.Articles;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
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

    public Articles toEntity() {
        return Articles.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
