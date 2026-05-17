package com.dondoc.upgrade.practice.entity;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecordEntity {
    private int id;
    private int userId;
    private int categoryId;
    private int amount;
    private String description;
    private String memo;
    private LocalDate recordDate;
    private LocalDateTime createdAt;

    public RecordEntity(int id, int userId, int categoryId, int amount, String description, String memo, LocalDate recordDate, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.categoryId = categoryId;
        this.amount = amount;
        this.description = description;
        this.memo = memo;
        this.recordDate = recordDate;
        this.createdAt = createdAt;
    }
}
