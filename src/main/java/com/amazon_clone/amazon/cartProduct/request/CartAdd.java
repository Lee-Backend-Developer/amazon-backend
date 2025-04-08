package com.amazon_clone.amazon.cartProduct.request;

import lombok.Builder;

public class CartAdd extends CartRequest {
    public CartAdd() {
    }

    @Builder
    public CartAdd(Long productId, int productCnt, Long cartId) {
        super(productId, productCnt, cartId);
    }
}
