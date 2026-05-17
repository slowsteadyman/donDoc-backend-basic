package com.dondoc.upgrade.practice.service;

import com.dondoc.upgrade.practice.dto.user.UserDto;
import com.dondoc.upgrade.practice.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getUsers() {
        return userRepository.findAll()
            .stream()
            .map(entity -> new UserDto(
                entity.getId(),
                entity.getUserId(),
                entity.getUserPassword(),
                entity.getName(),
                entity.getAge(),
                entity.getCurrentPigLevel(),
                entity.getCurrentHouseLevel(),
                entity.getMonthlyIncome(),
                entity.getTargetExpenseRatio(),
                entity.getCreatedAt()
            ))
            .collect(Collectors.toList());
    }
}
