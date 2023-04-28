package com.malorian.web;

import com.malorian.domain.article.ArticleRepository;
import com.malorian.service.article.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final ArticleService articleService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("articles", articleService.findAllDesc());
        return "views/index";
    }
}
