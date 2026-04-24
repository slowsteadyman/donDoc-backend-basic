package com.dondoc.upgrade.practice.controller;

import com.dondoc.upgrade.practice.dto.Records;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class RecordsController {
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
}
