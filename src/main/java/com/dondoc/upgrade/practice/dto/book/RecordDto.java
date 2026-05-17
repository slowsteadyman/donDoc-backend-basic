package com.dondoc.upgrade.practice.dto.book;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RecordDto {
    private int id;
    private int userId;
    private int categoryId;
    private int amount;
    private String description;
    private String memo;
    private LocalDate recordDate;
    private LocalDateTime createdAt;
}
