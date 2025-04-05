package com.amazon_clone.amazon.orders;

import com.amazon_clone.amazon.cartProduct.domain.Cart;
import com.amazon_clone.amazon.member.domain.Member;
import jakarta.persistence.*;

@Entity
public class Orders {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    private Member memberFk;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cartFk;
}
