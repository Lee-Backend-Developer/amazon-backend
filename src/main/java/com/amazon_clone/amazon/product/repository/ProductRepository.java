package com.amazon_clone.amazon.product.repository;

import com.amazon_clone.amazon.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
