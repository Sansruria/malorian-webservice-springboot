package com.malorian.web;

import com.malorian.service.article.ArticleService;
import com.malorian.web.dto.article.ArticleCreateRequestDto;
import com.malorian.web.dto.article.ArticleResponseDto;
import com.malorian.web.dto.article.ArticleUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ArticleApiController {

    private final ArticleService articleService;

    // Create
    @PostMapping("/api/v1/article/create")
    public Long create(@RequestBody ArticleCreateRequestDto requestDto) {
        return articleService.create(requestDto);
    }

    // Read
    @GetMapping("/api/v1/article/{id}")
    public ArticleResponseDto read(@PathVariable Long id) {
        return articleService.findById(id);
    }

    // Update
    @PutMapping("/api/v1/article/{id}")
    public Long update(@PathVariable Long id,
                       @RequestBody ArticleUpdateRequestDto requestDto) {
        return articleService.update(id, requestDto);
    }

    // Delete
    @DeleteMapping("/api/v1/delete/{id}")
    public Long delete(@PathVariable Long id) {
        articleService.delete(id);
        return id;
    }

}
