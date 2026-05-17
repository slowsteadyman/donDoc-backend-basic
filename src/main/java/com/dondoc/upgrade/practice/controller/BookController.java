package com.dondoc.upgrade.practice.controller;

import com.dondoc.upgrade.practice.dto.book.CategoryDto;
import com.dondoc.upgrade.practice.dto.book.MonthlyHistoryDto;
import com.dondoc.upgrade.practice.dto.book.RecordDto;
import com.dondoc.upgrade.practice.service.CategoryService;
import com.dondoc.upgrade.practice.service.MonthlyHistoryService;
import com.dondoc.upgrade.practice.service.RecordService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {
    private final RecordService recordService;
    private final CategoryService categoryService;
    private final MonthlyHistoryService monthlyHistoryService;

    @GetMapping("/records")
    public List<RecordDto> getRecords() {
        return recordService.getRecords();
    }

    @GetMapping("/categories")
    public List<CategoryDto> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/monthlyHistories")
    public List<MonthlyHistoryDto> getMonthlyHistories() {
        return monthlyHistoryService.getMonthlyHistories();
    }
}
