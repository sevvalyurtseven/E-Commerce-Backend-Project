package com.workintech.ecommerce.backend.service;

import com.workintech.ecommerce.backend.dto.CategoryResponseDto;
import com.workintech.ecommerce.backend.dto.ProductResponseDto;
import com.workintech.ecommerce.backend.entity.Category;
import com.workintech.ecommerce.backend.entity.Product;
import com.workintech.ecommerce.backend.exceptions.ProductException;
import com.workintech.ecommerce.backend.repository.ProductRepository;
import com.workintech.ecommerce.backend.utils.CategoryDtoConvertion;
import com.workintech.ecommerce.backend.utils.ProductDtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductResponseDto> findAll() {
        List<Product> products = productRepository.findAll();
        return ProductDtoConvertion.convertProductList(products);
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        throw new ProductException("Product not found with that id: " + id, HttpStatus.NOT_FOUND);
    }


    @Override
    public ProductResponseDto save(Product product) {
        productRepository.save(product);
        return ProductDtoConvertion.convertProduct(product);
    }

    @Override
    public Product delete(Long id) {
        Optional<Product> optional= productRepository.findById(id);
        if (optional.isPresent()) {
            productRepository.delete(optional.get());
            return optional.get();
        }
        throw new ProductException("Product not found with that id: " + id, HttpStatus.NOT_FOUND);
    }
}
