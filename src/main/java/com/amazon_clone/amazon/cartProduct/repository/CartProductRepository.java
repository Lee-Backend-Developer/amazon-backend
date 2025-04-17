package com.amazon_clone.amazon.cartProduct.repository;

import com.amazon_clone.amazon.cartProduct.domain.Cart;
import com.amazon_clone.amazon.cartProduct.domain.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
    List<CartProduct> findByCartFk_Id(long cartFkId);
}
