package com.workintech.ecommerce.backend.controller;

import com.workintech.ecommerce.backend.dto.CategoryResponseDto;
import com.workintech.ecommerce.backend.dto.ProductResponseDto;
import com.workintech.ecommerce.backend.entity.Category;
import com.workintech.ecommerce.backend.entity.Product;
import com.workintech.ecommerce.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public List<ProductResponseDto> productList(){
        return productService.findAll();
    }

    @PostMapping("/")
    public ProductResponseDto save(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Product delete(@PathVariable Long id){
        return productService.delete(id);
    }

}
