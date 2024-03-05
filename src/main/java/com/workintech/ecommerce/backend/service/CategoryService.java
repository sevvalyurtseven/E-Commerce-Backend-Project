package com.workintech.ecommerce.backend.service;

import com.workintech.ecommerce.backend.dto.CategoryResponseDto;
import com.workintech.ecommerce.backend.entity.Category;

import java.util.List;

public interface CategoryService {

        List<CategoryResponseDto> findAll();

        CategoryResponseDto findById(Long id);

        CategoryResponseDto save(Category category);

        CategoryResponseDto delete(Long id);

    }
