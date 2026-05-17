package com.dondoc.upgrade.practice.service;

import com.dondoc.upgrade.practice.dto.book.CategoryDto;
import com.dondoc.upgrade.practice.repository.CategoryRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> getCategories() {
        return categoryRepository.findAll()
            .stream()
            .map(entity -> new CategoryDto(
                entity.getId(),
                entity.getName(),
                entity.getIcon(),
                entity.getType()
            ))
            .collect(Collectors.toList());
    }
}
