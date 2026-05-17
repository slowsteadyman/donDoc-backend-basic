package com.dondoc.upgrade.practice.service;

import com.dondoc.upgrade.practice.dto.farm.FarmMemberDto;
import com.dondoc.upgrade.practice.repository.FarmMemberRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class FarmMemberService {
    private final FarmMemberRepository farmMemberRepository;

    public FarmMemberService(FarmMemberRepository farmMemberRepository) {
        this.farmMemberRepository = farmMemberRepository;
    }

    public List<FarmMemberDto> getFarmMembers() {
        return farmMemberRepository.findAll()
            .stream()
            .map(entity -> new FarmMemberDto(
                entity.getId(),
                entity.getUserId(),
                entity.getFarmId(),
                entity.getJoinedAt()
            ))
            .collect(Collectors.toList());
    }
}
