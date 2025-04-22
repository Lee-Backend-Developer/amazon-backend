package com.amazon_clone.amazon.orders.repository.querydsl;

import com.amazon_clone.amazon.orders.domain.OrdersNumberGenerator;
import com.amazon_clone.amazon.orders.domain.OrdersProduct;
import com.amazon_clone.amazon.orders.dto.repostiroyDto.OrderDto;
import com.amazon_clone.amazon.product.domain.Product;
import com.amazon_clone.amazon.product.domain.QProduct;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.amazon_clone.amazon.orders.domain.QOrdersNumberGenerator.*;
import static com.amazon_clone.amazon.orders.domain.QOrdersProduct.*;
import static com.amazon_clone.amazon.product.domain.QProduct.*;

@Slf4j
@RequiredArgsConstructor
@Repository
public class OrderProductRepositoryCustomImpl implements OrderProductRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    //    private OrdersNumberGenerator ordersNumberGeneratorFk;
    //    private List<Product> productFk;
    //    private int productCnt;
    //    private Member memberFk;
    //    private DeliveryStatus deliveryStatus;

    @Override
    public List<OrderDto> findByOrders(Long memberId) {
//        return List.of();
        List<OrderDto> responseList = new ArrayList<>();

        List<OrdersNumberGenerator> ordersNumberGeneratorList = jpaQueryFactory.selectFrom(ordersNumberGenerator)
                .where(ordersNumberGenerator.memberFk.id.eq(memberId))
                .fetch();

        // - 주문번호 여러개 여기에 페이징 걸자
        // - 배송상태
        // - 주문한 상품가격
        // - 상품 리스트
        ordersNumberGeneratorList
                .forEach(
                        orderNumber -> {
                            // 1. 주문번호 가지고 주문목록 가져온다.
                            List<OrdersProduct> ordersProductList = jpaQueryFactory.selectFrom(ordersProduct)
                                    .where(ordersProduct.ordersNumberGeneratorFk.eq(orderNumber))
                                    .fetch();

                            // 2. 주문목록에 있는 상품을 가져온다.
                            List<Product> products = ordersProductList
                                    .stream()
                                    .map(OrdersProduct::getProductFk).toList();


                            responseList.add(new OrderDto(orderNumber.getId(), orderNumber.getDeliveryStatus(), 1000, products));

                        }
                );

        return responseList;
    }
}
