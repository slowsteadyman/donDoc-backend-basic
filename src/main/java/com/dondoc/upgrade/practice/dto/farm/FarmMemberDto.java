package com.dondoc.upgrade.practice.dto.farm;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FarmMemberDto {
    private int id;
    private int userId;
    private int farmId;
    private LocalDateTime joinedAt;
}
