package com.amazon_clone.amazon.orders.repository;

import com.amazon_clone.amazon.orders.domain.OrdersProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrdersProduct, Long> {
}
