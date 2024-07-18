package com.workintech.ecommerce.backend.service;

import com.workintech.ecommerce.backend.dto.ProductResponseDto;
import com.workintech.ecommerce.backend.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> findAll();

    Product findById(Long id);

    Product save(Product product);

    Product delete(Long id);
}
