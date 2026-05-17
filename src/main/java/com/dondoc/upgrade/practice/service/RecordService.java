package com.dondoc.upgrade.practice.service;

import com.dondoc.upgrade.practice.dto.book.RecordDto;
import com.dondoc.upgrade.practice.repository.RecordRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class RecordService {
    private final RecordRepository recordRepository;

    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public List<RecordDto> getRecords() {
        return recordRepository.findAll()
            .stream()
            .map(entity -> new RecordDto(
                entity.getId(),
                entity.getUserId(),
                entity.getCategoryId(),
                entity.getAmount(),
                entity.getDescription(),
                entity.getMemo(),
                entity.getRecordDate(),
                entity.getCreatedAt()
            ))
            .collect(Collectors.toList());
    }
}
