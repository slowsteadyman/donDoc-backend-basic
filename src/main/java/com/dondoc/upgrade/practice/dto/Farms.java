package com.dondoc.upgrade.practice.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Farms {
    private int id;
    private String name;
    private LocalDateTime createdAt;

    public Farms(int id, String name, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }
}
