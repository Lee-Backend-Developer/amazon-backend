package com.amazon_clone.amazon.orders.repository;

import com.amazon_clone.amazon.orders.domain.OrdersNumberGenerator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersNumberGeneratorRepository extends JpaRepository<OrdersNumberGenerator, Long> {
}
