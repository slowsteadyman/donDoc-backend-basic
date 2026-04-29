package com.dondoc.upgrade.practice.controller.user;

import com.dondoc.upgrade.practice.dto.user.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @GetMapping("")
    public List<Users> getUsers() {
        return Arrays.asList(
            new Users(1, "kyujin123", "pass1", "최규진", 25, 1, 1, 3000000, 0.6, LocalDateTime.now()),
            new Users(2, "spring_fan", "pass2", "김철수", 22, 2, 1, 2500000, 0.5, LocalDateTime.now()),
            new Users(3, "java_master", "pass3", "이영희", 27, 3, 2, 4000000, 0.7, LocalDateTime.now()),
            new Users(4, "dondoc_user", "pass4", "박민수", 24, 1, 1, 2000000, 0.4, LocalDateTime.now()),
            new Users(5, "tester01", "pass5", "정다은", 26, 2, 2, 3500000, 0.8, LocalDateTime.now())
        );
    }
}