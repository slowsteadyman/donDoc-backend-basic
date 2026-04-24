package com.dondoc.upgrade.practice.controller;

import com.dondoc.upgrade.practice.dto.MonthlyHistory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class MonthlyHistoryController {
    @GetMapping("/monthlyHistory")
    public List<MonthlyHistory> getMonthlyHistory() {
        return Arrays.asList(
            new MonthlyHistory(1, 101, LocalDate.now(), 85.5, 3),
            new MonthlyHistory(2, 101, LocalDate.now(), 92.0, 4),
            new MonthlyHistory(3, 102, LocalDate.now(), 70.2, 2),
            new MonthlyHistory(4, 103, LocalDate.now(), 88.8, 3),
            new MonthlyHistory(5, 104, LocalDate.now(), 95.5, 5)
        );
    }
}
