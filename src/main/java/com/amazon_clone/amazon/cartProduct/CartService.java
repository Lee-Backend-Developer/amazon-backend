package com.amazon_clone.amazon.cartProduct;

import com.amazon_clone.amazon.cartProduct.domain.Cart;
import com.amazon_clone.amazon.cartProduct.domain.CartProduct;
import com.amazon_clone.amazon.cartProduct.dto.CartDto;
import com.amazon_clone.amazon.cartProduct.repository.CartProductRepository;
import com.amazon_clone.amazon.cartProduct.repository.CartRepository;
import com.amazon_clone.amazon.cartProduct.request.CartAdd;
import com.amazon_clone.amazon.product.domain.Product;
import com.amazon_clone.amazon.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class CartService {

    private final CartProductRepository cartProductRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Transactional
    public CartDto cartAdd(CartAdd request) {
        // todo .get()으로 가져오기 전에 체크하는 로직이 필요!!!
        Cart findCart = cartRepository.findById(request.getCartId())
                .get();

        Product findProduct = productRepository.findById(request.getProductId())
                .get();

        CartProduct saveCartProduct = CartProduct.builder()
                .productFk(findProduct)
                .cartFk(findCart)
                .productCnt(request.getProductCnt())
                .build();

        return CartDto.builder()
                .cartId(saveCartProduct.getId())
                .productId(saveCartProduct.getId())
                .productCnt(saveCartProduct.getProductCnt())
                .build();
    }

    @Transactional
    public void deleteCart(Long id) {
        cartProductRepository.deleteById(id);
    }
}
