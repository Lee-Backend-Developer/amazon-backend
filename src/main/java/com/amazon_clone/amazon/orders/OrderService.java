package com.amazon_clone.amazon.orders;

import com.amazon_clone.amazon.cartProduct.repository.CartProductRepository;
import com.amazon_clone.amazon.cartProduct.repository.CartRepository;
import com.amazon_clone.amazon.member.domain.Member;
import com.amazon_clone.amazon.member.repository.MemberRepository;
import com.amazon_clone.amazon.orders.domain.DeliveryStatus;
import com.amazon_clone.amazon.orders.domain.OrdersProduct;
import com.amazon_clone.amazon.orders.domain.OrdersNumberGenerator;
import com.amazon_clone.amazon.orders.dto.repostiroyDto.OrderDto;
import com.amazon_clone.amazon.orders.dto.response.GetOrderResponse;
import com.amazon_clone.amazon.orders.repository.OrderProductRepository;
import com.amazon_clone.amazon.orders.repository.OrdersNumberGeneratorRepository;
import com.amazon_clone.amazon.orders.dto.request.OrderAddRequest;
import com.amazon_clone.amazon.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class OrderService {
    private final OrdersNumberGeneratorRepository ordersNumberGeneratorRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final CartProductRepository cartProductRepository;
    private final CartRepository cartRepository;
    private final OrderProductRepository orderProductRepository;

    @Transactional
    public OrdersNumberGenerator createOrder(OrderAddRequest request) {
        Member findMember = memberRepository.findById(request.getMemberFk())
                .get();

        // 주문번호 생성
        OrdersNumberGenerator saveOrderNumberGenerator = OrdersNumberGenerator.builder()
                .memberFk(findMember)
                .deliveryStatus(DeliveryStatus.READY)
                .build();
        ordersNumberGeneratorRepository.save(saveOrderNumberGenerator);

        // 카트에 있는 제품을 주문에 추가
        cartProductRepository
                .findByCartFk_Id(request.getCartFk())
                        .forEach(cartProduct -> {
                            OrdersProduct createdOrdersProduct = OrdersProduct.builder()
                                    .ordersNumberGeneratorFk(saveOrderNumberGenerator)
                                    .productFk(cartProduct.getProductFk())
                                    .productCnt(cartProduct.getProductCnt())
                                    .build();
                            orderProductRepository.save(createdOrdersProduct);
                            // 카트에 담긴 제품 삭제
                            cartProductRepository.delete(cartProduct);
                        });

        return saveOrderNumberGenerator;
    }

    public List<GetOrderResponse> getOrderList(Long memberId) {
        List<OrderDto> orders = orderProductRepository.findByOrders(memberId);

        List<GetOrderResponse> getOrderResponseList = orders
                .stream()
                .map(dto -> {
                    List<GetOrderResponse.ProductInfo> productInfos = dto.getProductList()
                            .stream()
                            .map(product -> new GetOrderResponse.ProductInfo(product.getName(), product.getPrice()))
                            .toList();

                    return GetOrderResponse.builder()
                            .orderNumber(dto.getOrderNumber())
                            .deliveryStatus(dto.getDeliveryStatus().getStatus())
                            .orderProductPrice(dto.getOrderProductPrice())
                            .productList(productInfos)
                            .build();
                }).toList();

        return getOrderResponseList;
    }

}
