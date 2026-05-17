package com.dondoc.upgrade.practice.dto.book;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategoryDto {
    private int id;
    private String name;
    private String icon;
    private String type;
}
