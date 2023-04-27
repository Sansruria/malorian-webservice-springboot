package com.malorian.service.article;

import com.malorian.domain.article.ArticleRepository;
import com.malorian.web.dto.article.ArticleCreateRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    // Create
    @Transactional
    public Long create(ArticleCreateRequestDto requestDto) {
        return articleRepository.save(requestDto.toEntity()).getId();
    }

}
