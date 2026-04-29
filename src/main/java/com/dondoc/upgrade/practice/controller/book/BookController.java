package com.dondoc.upgrade.practice.controller.book;

import com.dondoc.upgrade.practice.dto.book.Categories;
import com.dondoc.upgrade.practice.dto.book.MonthlyHistory;
import com.dondoc.upgrade.practice.dto.book.Records;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @GetMapping("/records")
    public List<Records> getRecords() {
        return Arrays.asList(
            new Records(1, 101, 1, 15000, "점심 식사", "김치찌개", LocalDate.now(), LocalDateTime.now()),
            new Records(2, 101, 2, 2500, "버스비", "환승함", LocalDate.now(), LocalDateTime.now()),
            new Records(3, 102, 3, 3000000, "월급", "보너스 포함", LocalDate.of(2024, 4, 10), LocalDateTime.now()),
            new Records(4, 103, 1, 12000, "저녁 식사", "치킨", LocalDate.of(2024, 4, 15), LocalDateTime.now()),
            new Records(5, 104, 4, 55000, "게임 구매", "스팀 세일", LocalDate.of(2024, 4, 20), LocalDateTime.now())
        );
    }

    @GetMapping("/categories")
    public List<Categories> getCategories() {
        return Arrays.asList(
            new Categories(1, "식비", "food_icon", "SPEND"),
            new Categories(2, "교통", "bus_icon", "SPEND"),
            new Categories(3, "급여", "money_icon", "INCOME"),
            new Categories(4, "취미", "game_icon", "SPEND"),
            new Categories(5, "기타", "etc_icon", "SPEND")
        );
    }

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
