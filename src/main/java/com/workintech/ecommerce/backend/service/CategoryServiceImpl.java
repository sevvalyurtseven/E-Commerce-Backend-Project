package com.workintech.ecommerce.backend.service;

import com.workintech.ecommerce.backend.dto.CategoryResponseDto;
import com.workintech.ecommerce.backend.entity.Category;
import com.workintech.ecommerce.backend.exceptions.CategoryException;
import com.workintech.ecommerce.backend.repository.CategoryRepository;
import com.workintech.ecommerce.backend.utils.CategoryDtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryResponseDto> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return CategoryDtoConvertion.convertCategoryList(categories);
    }

    @Override
    public CategoryResponseDto findById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            return CategoryDtoConvertion.convertCategory(optionalCategory.get());
        }
        throw new CategoryException("Category not found with that id: " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public CategoryResponseDto save(Category category) {
        categoryRepository.save(category);
        return CategoryDtoConvertion.convertCategory(category);
    }

    @Override
    public CategoryResponseDto delete(Long id) {
        Optional<Category> optional = categoryRepository.findById(id);
        if (!optional.isPresent()){
            throw new CategoryException("Category not found with that id: " + id, HttpStatus.NOT_FOUND);
        }
        categoryRepository.delete(optional.get());
        return CategoryDtoConvertion.convertCategory(optional.get());
    }
}
