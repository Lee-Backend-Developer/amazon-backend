package com.amazon_clone.amazon.cartProduct.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class CartDto {
    private Long productId;
    private int productCnt;

    @Builder
    public CartDto(Long productId, int productCnt) {
        this.productId = productId;
        this.productCnt = productCnt;
    }
}
