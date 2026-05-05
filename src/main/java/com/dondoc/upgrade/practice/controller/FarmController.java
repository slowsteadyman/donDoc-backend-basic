package com.dondoc.upgrade.practice.controller;

import com.dondoc.upgrade.practice.dto.farm.FarmMembers;
import com.dondoc.upgrade.practice.dto.farm.Farms;
import com.dondoc.upgrade.practice.repository.FarmRepository;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/farms")
public class FarmController {
    private final FarmRepository farmRepository;

    public FarmController(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    @GetMapping("")
    public List<Map<String, Object>> getFarms() {
        return farmRepository.findFarms();
    }

    @GetMapping("/members")
    public List<Map<String, Object>> getFarmMembers() {
        return farmRepository.findFarmMembers();
    }
}