package com.malorian.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController_bak {


    // Insert Page
    @GetMapping(value = "/community/new2")
    public String write() {
        return "views/community/write";
    }

    // Modify Page
        @RequestMapping(value = "/articles/edit2", method = {RequestMethod.GET, RequestMethod.POST})
    public String modify(Model model) {

        model.addAttribute("seq", 1);
        model.addAttribute("category", "정보");
        model.addAttribute("title", "드디어 첫 게시글의 상세보기에요");
        model.addAttribute("name", "말로리안");
        model.addAttribute("date", DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()));
        model.addAttribute("count", 1);

        return "views/articles/modify";
    }
    // View Page
    @GetMapping(value = "/articles2")
    public String view(Model model) {

        model.addAttribute("seq", 1);
        model.addAttribute("category", "정보");
        model.addAttribute("title", "드디어 첫 게시글의 상세보기에요");
        model.addAttribute("name", "말로리안");
        model.addAttribute("date", DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()));
        model.addAttribute("count", 1);

        return "views/articles/view";
    }

}
