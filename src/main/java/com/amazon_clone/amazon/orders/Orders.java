package com.amazon_clone.amazon.orders;

import com.amazon_clone.amazon.cart.Cart;
import com.amazon_clone.amazon.member.Member;
import jakarta.persistence.*;

@Entity
public class Orders {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cart;
}
