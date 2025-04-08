package com.amazon_clone.amazon.cartProduct.request;

import lombok.Data;

@Data
public class CartRequest {
    private Long productId;
    private int productCnt;
    private Long cartId;

    public CartRequest() {
    }

    // 카트담기
    public CartRequest(Long productId, int productCnt, Long cartId) {
        this.productId = productId;
        this.productCnt = productCnt;
        this.cartId = cartId;
    }
}
