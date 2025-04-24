package com.amazon_clone.amazon.cartProduct.repository;

import com.amazon_clone.amazon.cartProduct.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByMemberFk_Id(Long memberFkId);
}
