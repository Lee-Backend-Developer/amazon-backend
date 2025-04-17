package com.amazon_clone.amazon.orders.domain;

public enum DeliveryStatus {
    READY, // 준비중
    DELIVERING, // 배송중
    DELIVERED, // 배송완료
    CANCELLED // 주문취소
}
