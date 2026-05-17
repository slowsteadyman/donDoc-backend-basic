package com.dondoc.upgrade.practice.service;

import com.dondoc.upgrade.practice.dto.book.MonthlyHistoryDto;
import com.dondoc.upgrade.practice.repository.MonthlyHistoryRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class MonthlyHistoryService {
    private final MonthlyHistoryRepository monthlyHistoryRepository;

    public MonthlyHistoryService(MonthlyHistoryRepository monthlyHistoryRepository) {
        this.monthlyHistoryRepository = monthlyHistoryRepository;
    }

    public List<MonthlyHistoryDto> getMonthlyHistories() {
        return monthlyHistoryRepository.findAll()
            .stream()
            .map(entity -> new MonthlyHistoryDto(
                entity.getId(),
                entity.getUserId(),
                entity.getTargetMonth(),
                entity.getAvgRatio(),
                entity.getHouseLevel()
            ))
            .collect(Collectors.toList());
    }
}
