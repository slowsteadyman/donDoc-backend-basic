package com.dondoc.upgrade.practice.controller;

import com.dondoc.upgrade.practice.dto.Farms;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class FarmsController {
    @GetMapping("/farms")
    public List<Farms> getFarms() {
        return Arrays.asList(
            new Farms(1, "우리집 농장", LocalDateTime.now().minusDays(10)),
            new Farms(2, "함께 가꾸기", LocalDateTime.now().minusDays(5)),
            new Farms(3, "주말 농장", LocalDateTime.now().minusDays(2)),
            new Farms(4, "친목 농장", LocalDateTime.now().minusDays(1)),
            new Farms(5, "비밀 정원", LocalDateTime.now())
        );
    }
}