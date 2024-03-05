package com.workintech.ecommerce.backend.controller;

import com.workintech.ecommerce.backend.dto.CategoryResponseDto;
import com.workintech.ecommerce.backend.entity.Category;
import com.workintech.ecommerce.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public List<CategoryResponseDto> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryResponseDto findById(@PathVariable Long id){
        return categoryService.findById(id);
    }

    @PostMapping("/")
    public CategoryResponseDto save(@RequestBody Category category){
        return categoryService.save(category);
    }

    @DeleteMapping("/{id}")
    public CategoryResponseDto delete(@PathVariable Long id){
        return categoryService.delete(id);
    }
}
