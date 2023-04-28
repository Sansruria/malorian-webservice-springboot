package com.malorian.service.article;

import com.malorian.domain.article.Articles;
import com.malorian.domain.article.ArticleRepository;
import com.malorian.web.dto.article.ArticleCreateRequestDto;
import com.malorian.web.dto.article.ArticleResponseDto;
import com.malorian.web.dto.article.ArticleUpdateRequestDto;
import com.malorian.web.dto.article.ArticlesListResponseDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    // Create
    @Transactional
    public Long create(ArticleCreateRequestDto requestDto) {
        return articleRepository.save(requestDto.toEntity()).getId();
    }

    // Read
    // 게시글을 읽을 때 사용되는 메소드
    @Transactional
    public ArticleResponseDto detail(Long id) {
        Articles entity = articleRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        articleRepository.viewAndHit(id);
        return new ArticleResponseDto(entity);
    }

    // Read FindById
    // 게시글을 수정할 때 게시글의 정보를 가져올 때 사용되는 메소드
    @Transactional
    public ArticleResponseDto findById(Long id) {
        Articles entity = articleRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new ArticleResponseDto(entity);
    }

    // Update
    @Transactional
    public Long update(Long id, ArticleUpdateRequestDto requestDto) {
        Articles article = articleRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        article.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    // Delete
    @Transactional
    public void delete(Long id) {
        Articles article = articleRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        articleRepository.delete(article);
    }

    // List
    @Transactional
    public List<ArticlesListResponseDto> findAllDesc() {
        return articleRepository.findAllDesc().stream()
                .map(ArticlesListResponseDto::new)
                .collect(Collectors.toList());
    }

}
