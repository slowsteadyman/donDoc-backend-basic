package com.dondoc.upgrade.practice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryEntity {
    private int id;
    private String name;
    private String icon;
    private String type;

    public CategoryEntity(int id, String name, String icon, String type) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.type = type;
    }
}
