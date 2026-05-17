package com.dondoc.upgrade.practice.controller;

import com.dondoc.upgrade.practice.dto.user.UserDto;
import com.dondoc.upgrade.practice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public List<UserDto> getUsers() {
       return userService.getUsers();
    }
}