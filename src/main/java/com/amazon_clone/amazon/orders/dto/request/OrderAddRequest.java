package com.amazon_clone.amazon.orders.dto.request;

public class OrderAddRequest extends OrderRequest{
    public OrderAddRequest() {
    }

    public OrderAddRequest(Long memberFk, Long cartFk) {
        super(memberFk, cartFk);
    }
}
