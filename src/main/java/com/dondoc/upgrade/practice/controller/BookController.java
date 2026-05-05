package com.dondoc.upgrade.practice.controller;

import com.dondoc.upgrade.practice.dto.book.Categories;
import com.dondoc.upgrade.practice.dto.book.MonthlyHistory;
import com.dondoc.upgrade.practice.dto.book.Records;
import com.dondoc.upgrade.practice.repository.BookRepository;
import java.util.Map;
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
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/records")
    public List<Map<String, Object>> getRecords() {
        return bookRepository.findRecords();
    }

    @GetMapping("/categories")
    public List<Map<String, Object>> getCategories() {
        return bookRepository.findCategories();
    }

    @GetMapping("/monthlyHistories")
    public List<Map<String, Object>> getMonthlyHistories() {
        return bookRepository.findMonthlyHistories();
    }
}
