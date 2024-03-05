package com.workintech.ecommerce.backend.dto;

public record ProductResponseDto( Long id,
                                  String name,
                                  String description,
                                  Double price,
                                  Integer stock,
                                  Double rating,
                                  Integer sell_count,
                                  String images,
                                  Long store_id,
                                  Long category_id
) {
}