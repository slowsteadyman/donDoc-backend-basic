package com.dondoc.upgrade.practice.controller;

import com.dondoc.upgrade.practice.dto.farm.FarmDto;
import com.dondoc.upgrade.practice.dto.farm.FarmMemberDto;
import com.dondoc.upgrade.practice.service.FarmMemberService;
import com.dondoc.upgrade.practice.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/farms")
@RequiredArgsConstructor
public class FarmController {
    private final FarmService farmService;
    private final FarmMemberService farmMemberService;

    @GetMapping("")
    public List<FarmDto> getFarms() {
        return farmService.getFarms();
    }

    @GetMapping("/members")
    public List<FarmMemberDto> getFarmMembers() {
        return farmMemberService.getFarmMembers();
    }
}