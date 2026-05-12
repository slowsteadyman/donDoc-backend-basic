package com.dondoc.upgrade.practice.entity;

import java.time.LocalDateTime;

public class UserEntity {
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

    public UserEntity(int id, String userId, String userPassword, String name, int age, int currentPigLevel, int currentHouseLevel, int monthlyIncome, double targetExpenseRatio, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.userPassword = userPassword;
        this.name = name;
        this.age = age;
        this.currentPigLevel = currentPigLevel;
        this.currentHouseLevel = currentHouseLevel;
        this.monthlyIncome = monthlyIncome;
        this.targetExpenseRatio = targetExpenseRatio;
        this.createdAt = createdAt;
    }
}
