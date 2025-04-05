package com.amazon_clone.amazon.cartProduct;

import com.amazon_clone.amazon.cartProduct.request.CartRequest;
import com.amazon_clone.amazon.cartProduct.response.CartResponse;
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
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;

    @PutMapping("add")
    public ResponseEntity<CartResponse> addCart(@RequestBody CartRequest cart) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
