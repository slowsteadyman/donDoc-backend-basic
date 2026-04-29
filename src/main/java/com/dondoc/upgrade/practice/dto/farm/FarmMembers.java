package com.dondoc.upgrade.practice.dto.farm;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FarmMembers {
    private int id;
    private int userId;
    private int farmId;
    private LocalDateTime joinedAt;

    public FarmMembers(int id, int userId, int farmId, LocalDateTime joinedAt) {
        this.id = id;
        this.userId = userId;
        this.farmId = farmId;
        this.joinedAt = joinedAt;
    }
}
