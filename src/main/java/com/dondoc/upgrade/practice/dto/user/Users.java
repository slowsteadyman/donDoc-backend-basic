package com.dondoc.upgrade.practice.dto.user;

import java.time.LocalDateTime;

public class Users {
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

    public Users(int id, String userId, String userPassword, String name, int age, int currentPigLevel, int currentHouseLevel, int monthlyIncome, double targetExpenseRatio, LocalDateTime createdAt) {
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

    public int getCurrentPigLevel() {
        return currentPigLevel;
    }

    public int getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getCurrentHouseLevel() {
        return currentHouseLevel;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public double getTargetExpenseRatio() {
        return targetExpenseRatio;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
