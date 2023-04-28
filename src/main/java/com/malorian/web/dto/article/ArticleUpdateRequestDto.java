package com.malorian.web.dto.article;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ArticleUpdateRequestDto {

    private String title;
    private String content;

    @Builder
    public ArticleUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
