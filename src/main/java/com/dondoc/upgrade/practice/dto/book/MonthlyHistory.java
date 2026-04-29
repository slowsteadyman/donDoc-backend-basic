package com.dondoc.upgrade.practice.dto.book;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MonthlyHistory {
    private int id;
    private int userId;
    private LocalDate targetMonth;
    private double avgRatio;
    private int houseLevel;

    public MonthlyHistory(int id, int userId, LocalDate targetMonth, double avgRatio, int houseLevel) {
        this.id = id;
        this.userId = userId;
        this.targetMonth = targetMonth;
        this.avgRatio = avgRatio;
        this.houseLevel = houseLevel;
    }
}
