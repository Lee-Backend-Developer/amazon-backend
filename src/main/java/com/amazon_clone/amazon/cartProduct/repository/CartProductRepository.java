package com.amazon_clone.amazon.cartProduct.repository;

import com.amazon_clone.amazon.cartProduct.domain.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
}
