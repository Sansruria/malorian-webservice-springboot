package com.malorian.web;

import com.malorian.service.article.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class ArticleController {
    private final ArticleService articleService;

    // Create
    @GetMapping("/community/new")
    public String write() {
        return "views/community/write";
    }

}
