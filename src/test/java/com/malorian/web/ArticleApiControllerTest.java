package com.malorian.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.malorian.domain.article.ArticleRepository;
import com.malorian.domain.article.Articles;
import com.malorian.web.dto.article.ArticleCreateRequestDto;
import com.malorian.web.dto.article.ArticleUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArticleApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ArticleRepository articleRepository;

    @After
    public void teraDown() throws Exception {
        articleRepository.deleteAll();
    }

    @Test
    public void Article_등록된다() throws Exception {
        String title = "이것은 제목입니다";
        String content = "이거슨 내용입닌다";
        ArticleCreateRequestDto requestDto = ArticleCreateRequestDto.builder()
                .title(title)
                .content(content)
                .author("그리고 나는 글쓴이입니다")
                .build();

        String url = "http://localhost:" + port + "/api/v1/article/create";

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Articles> all = articleRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);

    }

    @Test
    public void Article_수정된다() throws Exception {
        Articles createArticle = articleRepository.save(Articles.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        Long updateId = createArticle.getId();
        String expectedTitle = "title2";
        String expectedContent = "content2";

        ArticleUpdateRequestDto requestDto = ArticleUpdateRequestDto.builder()
                .title(expectedTitle)
                .content(expectedContent)
                .build();

        String url = "http://localhost:" + port + "/api/v1/article/" + updateId;

        HttpEntity<ArticleUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Articles> all = articleRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);

    }

}
