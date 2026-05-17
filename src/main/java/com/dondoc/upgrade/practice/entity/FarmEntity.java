package com.dondoc.upgrade.practice.entity;

import lombok.Getter;

import java.time.LocalDateTime;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
