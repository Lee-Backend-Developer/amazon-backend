package com.amazon_clone.amazon.orders.repository;

import com.amazon_clone.amazon.orders.domain.OrdersProduct;
import com.amazon_clone.amazon.orders.dto.repostiroyDto.OrderDto;
import com.amazon_clone.amazon.orders.repository.querydsl.OrderProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderProductRepository extends JpaRepository<OrdersProduct, Long>, OrderProductRepositoryCustom {
    List<OrderDto> findByOrders(Long memberId);

    List<OrdersProduct> findByOrdersNumberGeneratorFk_Id(Long ordersNumberGeneratorFkId);
}
