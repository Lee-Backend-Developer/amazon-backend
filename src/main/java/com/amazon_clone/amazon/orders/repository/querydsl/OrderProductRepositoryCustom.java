package com.amazon_clone.amazon.orders.repository.querydsl;

import com.amazon_clone.amazon.orders.dto.repostiroyDto.OrderDto;

import java.util.List;

public interface OrderProductRepositoryCustom {
    List<OrderDto> findByOrders(Long memberId);
    
}
