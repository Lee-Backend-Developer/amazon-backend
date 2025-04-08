package com.amazon_clone.amazon.cartProduct.repository;

import com.amazon_clone.amazon.cartProduct.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
