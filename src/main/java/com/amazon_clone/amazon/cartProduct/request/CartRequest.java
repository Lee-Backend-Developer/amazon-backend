package com.amazon_clone.amazon.cartProduct.request;

public class CartRequest {
    private String productId;
    private Long memberId;

    public CartRequest() {
    }

    public CartRequest(String productId, Long memberId) {
        this.productId = productId;
        this.memberId = memberId;
    }
}
