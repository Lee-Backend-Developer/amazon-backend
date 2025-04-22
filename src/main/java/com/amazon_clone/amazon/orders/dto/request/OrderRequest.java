package com.amazon_clone.amazon.orders.dto.request;

import com.amazon_clone.amazon.cartProduct.domain.Cart;
import com.amazon_clone.amazon.member.domain.Member;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class OrderRequest {
    private Long memberFk;
    private Long cartFk;

    public OrderRequest() {
    }

    @Builder
    public OrderRequest(Long memberFk, Long cartFk) {
        this.memberFk = memberFk;
        this.cartFk = cartFk;
    }
}
