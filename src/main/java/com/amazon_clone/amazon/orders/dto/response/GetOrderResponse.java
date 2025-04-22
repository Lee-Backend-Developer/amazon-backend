package com.amazon_clone.amazon.orders.dto.response;

import com.amazon_clone.amazon.product.domain.Product;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Builder
public class GetOrderResponse {
    private final Long orderNumber;   // 주문번호
    private final String deliveryStatus; // 배송상태
    private final int orderProductPrice;  // 주문한 상품가격
    private final List<ProductInfo> productList; // 주문한 상품 리스트

    @Getter
    static public class ProductInfo {
        private final String productName;
        private final int productPrice;

        public ProductInfo(String productName, int productPrice) {
            this.productName = productName;
            this.productPrice = productPrice;
        }
    }
}
