package com.amazon_clone.amazon.orders.dto.repostiroyDto;

import com.amazon_clone.amazon.orders.domain.DeliveryStatus;
import com.amazon_clone.amazon.product.domain.Product;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Setter
public class OrderDto {
    private final Long orderNumber;   // 주문번호
    private final DeliveryStatus deliveryStatus; // 배송상태
    private final int orderProductPrice;  // 주문한 상품가격
    private final List<Product> productList; // 주문한 상품 리스트


    public OrderDto(Long orderNumber, DeliveryStatus deliveryStatus, int orderProductPrice, List<Product> productList) {
        this.orderNumber = orderNumber;
        this.deliveryStatus = deliveryStatus;
        this.orderProductPrice = orderProductPrice;
        this.productList = productList;
    }
}
