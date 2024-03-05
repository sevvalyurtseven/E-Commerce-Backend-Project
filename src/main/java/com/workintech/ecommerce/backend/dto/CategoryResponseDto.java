package com.workintech.ecommerce.backend.dto;

import com.workintech.ecommerce.backend.entity.Category;
import com.workintech.ecommerce.backend.entity.Gender;

public record CategoryResponseDto(Long id,
                                  String code,
                                  Gender gender,
                                  String img,
                                  Double rating,
                                  String title) {}
