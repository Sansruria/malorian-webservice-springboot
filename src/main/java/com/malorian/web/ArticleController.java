package com.malorian.web;

import com.malorian.service.article.ArticleService;
import com.malorian.web.dto.article.ArticleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class ArticleController {
    private final ArticleService articleService;

    // Create Page
    @GetMapping("/article/new")
    public String write() {
        return "views/articles/write";
    }

    // Read Page
    @GetMapping("/article/{id}")
    public String view(@PathVariable Long id, Model model) {
        ArticleResponseDto responseDto = articleService.detail(id);
        model.addAttribute("article", responseDto);
        return "views/articles/view";
    }

    // Update Page
    @GetMapping("/article/update/{id}")
    public String modify(@PathVariable Long id, Model model) {
        ArticleResponseDto responseDto = articleService.findById(id);
        model.addAttribute("article", responseDto);
        return "views/articles/update";
    }

}
