package com.dondoc.upgrade.practice.dto.book;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class Records {
    private int id;
    private int userId;
    private int categoryId;
    private int amount;
    private String description;
    private String memo;
    private LocalDate recordDate;
    private LocalDateTime createdAt;

    public Records(int id, int userId, int categoryId, int amount, String description, String memo, LocalDate recordDate, LocalDateTime createdAt) {
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
