package com.dondoc.upgrade.practice.dto.user;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {
    private int id;
    private String userId;
    private String userPassword;
    private String name;
    private int age;
    private int currentPigLevel;
    private int currentHouseLevel;
    private int monthlyIncome;
    private double targetExpenseRatio;
    private LocalDateTime createdAt;
}
