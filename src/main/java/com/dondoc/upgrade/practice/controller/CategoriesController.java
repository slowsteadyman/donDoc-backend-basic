package com.dondoc.upgrade.practice.controller;

import com.dondoc.upgrade.practice.dto.Categories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CategoriesController {
    @GetMapping("/categories")
    public List<Categories> getCategories() {
        return Arrays.asList(
            new Categories(1, "식비", "food_icon", "SPEND"),
            new Categories(2, "교통", "bus_icon", "SPEND"),
            new Categories(3, "급여", "money_icon", "INCOME"),
            new Categories(4, "취미", "game_icon", "SPEND"),
            new Categories(5, "기타", "etc_icon", "SPEND")
        );
    }
}