package com.amazon_clone.amazon.cartProduct.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class CartDto {
    private Long cartId;
    private Long productId;
    private int productCnt;

    @Builder
    public CartDto(Long cartId, Long productId, int productCnt) {
        this.cartId = cartId;
        this.productId = productId;
        this.productCnt = productCnt;
    }
}
