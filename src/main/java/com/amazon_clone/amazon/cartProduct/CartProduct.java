package com.amazon_clone.amazon.cartProduct;

import com.amazon_clone.amazon.cart.Cart;
import com.amazon_clone.amazon.product.domain.Product;
import jakarta.persistence.*;

@Entity
public class CartProduct {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    private Product productFk;

    @ManyToOne
    private Cart cartFk;

    private int productCnt;
}
