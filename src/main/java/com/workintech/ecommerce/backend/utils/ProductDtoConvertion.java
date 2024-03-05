package com.workintech.ecommerce.backend.utils;

import com.workintech.ecommerce.backend.dto.ProductResponseDto;
import com.workintech.ecommerce.backend.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDtoConvertion {
    public static List<ProductResponseDto> convertProductList(List<Product> products){
        List<ProductResponseDto> productResponses = new ArrayList<>();

        products.stream().forEach(product -> productResponses.add(new ProductResponseDto(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getStock(), product.getRating(), product.getSellCount(), product.getImages(), product.getCategory().getId(), product.getStore().getId())));
        return productResponses;
    }

    public static ProductResponseDto convertProduct(Product product){
        return new ProductResponseDto(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getStock(), product.getRating(), product.getSellCount(), product.getImages(), product.getCategory().getId(), product.getStore().getId());
    }
}
