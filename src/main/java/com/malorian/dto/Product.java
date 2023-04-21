package com.malorian.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    private int seq;
    private String category;
    private String title;
    private String name;
    private int count;
}
