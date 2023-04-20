package com.malorian.web;

import com.malorian.dto.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

//    @GetMapping("/")
    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
    public String index(Model model) {
        List<Product> productList = new ArrayList<>();

        productList.add(new Product(1,"정보","드디어 첫 게시글을 작성해 보아요","말로리안",1));
        productList.add(new Product(2,"정보","드디어 첫 게시글을 작성해 보아요","말로리안",1));
        productList.add(new Product(3,"정보","드디어 첫 게시글을 작성해 보아요","말로리안",1));
        productList.add(new Product(4,"정보","드디어 첫 게시글을 작성해 보아요","말로리안",1));
        productList.add(new Product(5,"정보","드디어 첫 게시글을 작성해 보아요","말로리안",1));

        model.addAttribute("productList", productList);

        return "views/index";
    }

}
