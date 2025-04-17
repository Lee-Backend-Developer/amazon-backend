package com.amazon_clone.amazon.orders.domain;

import com.amazon_clone.amazon.member.domain.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class OrdersNumberGenerator {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member memberFk;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @Builder
    public OrdersNumberGenerator(Member memberFk, DeliveryStatus deliveryStatus) {
        this.memberFk = memberFk;
        this.deliveryStatus = deliveryStatus;
    }
}
