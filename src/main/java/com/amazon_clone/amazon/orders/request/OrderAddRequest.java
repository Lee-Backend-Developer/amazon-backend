package com.amazon_clone.amazon.orders.request;

import com.amazon_clone.amazon.cartProduct.domain.Cart;
import com.amazon_clone.amazon.member.domain.Member;

public class OrderAddRequest extends OrderRequest{
    public OrderAddRequest() {
    }

    public OrderAddRequest(Long memberFk, Long cartFk) {
        super(memberFk, cartFk);
    }
}
