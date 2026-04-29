package com.dondoc.upgrade.practice.controller.farm;

import com.dondoc.upgrade.practice.dto.FarmMembers;
import com.dondoc.upgrade.practice.dto.Farms;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/farms")
public class FarmController {
    @GetMapping("")
    public List<Farms> getFarms() {
        return Arrays.asList(
            new Farms(1, "우리집 농장", LocalDateTime.now().minusDays(10)),
            new Farms(2, "함께 가꾸기", LocalDateTime.now().minusDays(5)),
            new Farms(3, "주말 농장", LocalDateTime.now().minusDays(2)),
            new Farms(4, "친목 농장", LocalDateTime.now().minusDays(1)),
            new Farms(5, "비밀 정원", LocalDateTime.now())
        );
    }

    @GetMapping("/members")
    public List<FarmMembers> getFarmMembers() {
        return Arrays.asList(
            new FarmMembers(1, 101, 1, LocalDateTime.now().minusDays(10)),
            new FarmMembers(2, 102, 1, LocalDateTime.now().minusDays(9)),
            new FarmMembers(3, 103, 2, LocalDateTime.now().minusDays(4)),
            new FarmMembers(4, 104, 3, LocalDateTime.now().minusDays(2)),
            new FarmMembers(5, 105, 5, LocalDateTime.now())
        );
    }
}