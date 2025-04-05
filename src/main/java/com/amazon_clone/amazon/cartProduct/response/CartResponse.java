package com.amazon_clone.amazon.cartProduct.response;

import com.amazon_clone.amazon.common.Response;
import org.springframework.http.HttpStatus;

public class CartResponse extends Response {
    public CartResponse(Object response, HttpStatus status) {
        super(response, status);
    }
}
