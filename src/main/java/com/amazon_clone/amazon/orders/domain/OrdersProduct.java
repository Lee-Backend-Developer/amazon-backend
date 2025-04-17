package com.amazon_clone.amazon.orders.domain;

import com.amazon_clone.amazon.product.domain.Product;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class OrdersProduct {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private OrdersNumberGenerator ordersNumberGeneratorFk;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product productFk;

    private int productCnt;

    @Builder
    public OrdersProduct(OrdersNumberGenerator ordersNumberGeneratorFk, Product productFk, int productCnt) {
        this.ordersNumberGeneratorFk = ordersNumberGeneratorFk;
        this.productFk = productFk;
        this.productCnt = productCnt;
    }
}
