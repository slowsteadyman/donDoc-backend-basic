package com.dondoc.upgrade.practice.dto.book;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MonthlyHistoryDto {
    private int id;
    private int userId;
    private LocalDate targetMonth;
    private double avgRatio;
    private int houseLevel;
}
