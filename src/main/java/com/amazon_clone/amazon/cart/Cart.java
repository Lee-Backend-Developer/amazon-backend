package com.amazon_clone.amazon.cart;

import com.amazon_clone.amazon.CartProduct.CartProduct;
import com.amazon_clone.amazon.member.Member;
import com.amazon_clone.amazon.product.Product;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cart {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private CartProduct product;

}
