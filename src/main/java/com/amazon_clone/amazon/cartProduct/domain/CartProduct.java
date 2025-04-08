package com.amazon_clone.amazon.cartProduct.domain;

import com.amazon_clone.amazon.product.domain.Product;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class CartProduct {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product productFk;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cartFk;

    private int productCnt;

    @Builder
    public CartProduct(Product productFk, Cart cartFk, int productCnt) {
        this.productFk = productFk;
        this.cartFk = cartFk;
        this.productCnt = productCnt;
    }
}
