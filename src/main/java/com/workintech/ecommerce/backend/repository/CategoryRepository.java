package com.workintech.ecommerce.backend.repository;

import com.workintech.ecommerce.backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
