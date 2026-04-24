package com.dondoc.upgrade.practice.controller;

import com.dondoc.upgrade.practice.dto.FarmMembers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class FarmMembersController {
    @GetMapping("/farmMembers")
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
