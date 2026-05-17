package com.dondoc.upgrade.practice.service;

import com.dondoc.upgrade.practice.dto.farm.FarmDto;
import com.dondoc.upgrade.practice.repository.FarmRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class FarmService {
    private final FarmRepository farmRepository;

    public FarmService(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    public List<FarmDto> getFarms() {
        return farmRepository.findAll()
            .stream()
            .map(entity -> new FarmDto(
                entity.getId(),
                entity.getName(),
                entity.getCreatedAt()
            ))
            .collect(Collectors.toList());
    }
}
