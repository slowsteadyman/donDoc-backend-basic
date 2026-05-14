package com.dondoc.upgrade.practice.entity;

import lombok.Getter;

import java.time.LocalDateTime;
import lombok.Setter;

@Getter
@Setter
public class FarmMemberEntity {
    private int id;
    private int userId;
    private int farmId;
    private LocalDateTime joinedAt;

    public FarmMemberEntity(int id, int userId, int farmId, LocalDateTime joinedAt) {
        this.id = id;
        this.userId = userId;
        this.farmId = farmId;
        this.joinedAt = joinedAt;
    }
}
