package com.dondoc.upgrade.practice.dto;

import lombok.Getter;

@Getter
public class Categories {
    private int id;
    private String name;
    private String icon;
    private String type;

    public Categories(int id, String name, String icon, String type) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.type = type;
    }
}
