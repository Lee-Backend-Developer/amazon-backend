package com.amazon_clone.amazon.category.repository;

import com.amazon_clone.amazon.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
