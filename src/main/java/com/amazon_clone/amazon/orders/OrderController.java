package com.amazon_clone.amazon.orders;

import com.amazon_clone.amazon.orders.domain.OrdersNumberGenerator;
import com.amazon_clone.amazon.orders.request.OrderAddRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    // 주문 생성
    @PutMapping("/create")
    public ResponseEntity create(@RequestBody OrderAddRequest request) {
        OrdersNumberGenerator order = orderService.createOrder(request);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

}
