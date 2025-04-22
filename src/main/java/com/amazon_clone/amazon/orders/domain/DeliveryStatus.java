package com.amazon_clone.amazon.orders.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum DeliveryStatus {
    READY("READY"), // 준비중
    DELIVERING("DELIVERING"), // 배송중
    DELIVERED("DELIVERED"), // 배송완료
    CANCELLED("CANCELLED"); // 주문취소

    private final String status;

    DeliveryStatus(String status) {
        this.status = status;
    }

}
