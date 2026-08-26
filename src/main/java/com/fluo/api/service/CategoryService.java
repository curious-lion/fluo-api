package com.fluo.api.service;

import com.fluo.api.dto.CategoryRequest;
import com.fluo.api.dto.CategoryResponse;
import com.fluo.api.model.Category;
import com.fluo.api.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> new CategoryResponse(category.getId(), category.getName()))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoryResponse create(CategoryRequest categoryRequest) {
        if (categoryRepository.existsByName(categoryRequest.getName())) {
            throw new IllegalArgumentException("Category already exists");
        }

        Category category = Category.builder()
                .name(categoryRequest.getName())
                .build();

        Category savedCategory = categoryRepository.save(category);
        return new CategoryResponse(savedCategory.getId(), savedCategory.getName());
    }

    @Transactional
    public void delete(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new IllegalArgumentException("Unable to delete: category does not exist");
        }

        // TODO: Before deleting, verify if there are transactions associated with it

        categoryRepository.deleteById(id);
    }
}
