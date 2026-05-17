package com.dondoc.upgrade.practice.dto.farm;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class FarmDto {
    private int id;
    private String name;
    private LocalDateTime createdAt;
}
