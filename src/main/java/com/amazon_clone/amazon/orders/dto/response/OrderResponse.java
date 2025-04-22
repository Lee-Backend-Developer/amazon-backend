package com.amazon_clone.amazon.orders.dto.response;

import com.amazon_clone.amazon.common.Response;
import org.springframework.http.HttpStatus;

public class OrderResponse extends Response {
    public OrderResponse(Object response, HttpStatus status) {
        super(response, status);
    }
}
