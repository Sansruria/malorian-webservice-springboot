package com.malorian.domain.article;

import com.malorian.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Articles extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String content;
    private String author;
    private int hit;

    @Builder
    public Articles(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.hit = 0;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
