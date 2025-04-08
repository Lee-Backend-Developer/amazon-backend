package com.amazon_clone.amazon.cartProduct;

import com.amazon_clone.amazon.cartProduct.domain.CartProduct;
import com.amazon_clone.amazon.cartProduct.dto.CartDto;
import com.amazon_clone.amazon.cartProduct.request.CartAdd;
import com.amazon_clone.amazon.cartProduct.request.CartRequest;
import com.amazon_clone.amazon.cartProduct.response.CartResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;

    @PutMapping("add")
    public ResponseEntity<CartResponse> addCart(@RequestBody CartAdd request) {
        CartDto cartDto = cartService.cartAdd(request);
        CartResponse response = new CartResponse(cartDto, HttpStatus.CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CartResponse> deleteCart(@PathVariable("id") Long id) {
        cartService.deleteCart(id);
        CartResponse response = new CartResponse(null, HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
