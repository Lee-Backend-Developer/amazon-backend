package com.amazon_clone.amazon.orders.repository;

import com.amazon_clone.amazon.orders.domain.OrdersNumberGenerator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersNumberGeneratorRepository extends JpaRepository<OrdersNumberGenerator, Long> {
    List<OrdersNumberGenerator> findByMemberFk_Id(Long memberId);
}
