package com.dondoc.upgrade.practice.entity;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MonthlyHistoryEntity {
    private int id;
    private int userId;
    private LocalDate targetMonth;
    private double avgRatio;
    private int houseLevel;

    public MonthlyHistoryEntity(int id, int userId, LocalDate targetMonth, double avgRatio, int houseLevel) {
        this.id = id;
        this.userId = userId;
        this.targetMonth = targetMonth;
        this.avgRatio = avgRatio;
        this.houseLevel = houseLevel;
    }
}
