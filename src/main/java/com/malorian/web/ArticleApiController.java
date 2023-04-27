package com.malorian.web;

import com.malorian.service.article.ArticleService;
import com.malorian.web.dto.article.ArticleCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ArticleApiController {

    private final ArticleService articleService;

    // Insert
    @PostMapping("/api/v1/article/create")
    public Long create(@RequestBody ArticleCreateRequestDto requestDto) {
        return articleService.create(requestDto);
    }

    // View
    // Update
    // Delete

    /*
    @PostMapping("/api/v1/board/write")
    public Long save(@RequestBody BoardSaveRequestDto requestDto) {
        return boardService.save(requestDto);
    }

    @GetMapping("/api/v1/board/{id}")
    public BoardResponseDto view(@PathVariable Long id) {
        return boardService.findById(id);
    }

    @PutMapping("/api/v1/board/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto requestDto) {
        return boardService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/delete/{id}")
    public Long delete(@PathVariable Long id) {
        boardService.delete(id);
        return id;
        */
}
