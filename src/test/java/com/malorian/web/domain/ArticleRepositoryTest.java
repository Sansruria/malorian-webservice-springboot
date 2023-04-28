package com.malorian.web.domain;

import com.malorian.domain.article.ArticleRepository;
import com.malorian.domain.article.Articles;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleRepositoryTest {

    @Autowired
    ArticleRepository articleRepository;

    @After
    public void cleanup() {
        articleRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        articleRepository.save(Articles.builder()
                        .title(title)
                        .content(content)
                        .author("malolian@gmail.com")
                        .build());

        List<Articles> articlesList = articleRepository.findAll();

        Articles articles = articlesList.get(0);
        assertThat(articles.getTitle()).isEqualTo(title);
        assertThat(articles.getContent()).isEqualTo(content);

    }

    @Test
    public void BaseTimeEntity_등록() {
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        articleRepository.save(Articles.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        List<Articles> articlesList = articleRepository.findAll();

        Articles articles = articlesList.get(0);

        System.out.println(">>>>>>>>>> createDate=" + articles.getCreateDate() +
                ", modifiedDate=" + articles.getModifiedDate());

        assertThat(articles.getCreateDate()).isAfter(now);
        assertThat(articles.getModifiedDate()).isAfter(now);

    }

}
