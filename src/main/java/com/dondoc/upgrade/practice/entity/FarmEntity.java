package com.dondoc.upgrade.practice.entity;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FarmEntity {
    private int id;
    private String name;
    private LocalDateTime createdAt;

    public FarmEntity(int id, String name, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }
}
