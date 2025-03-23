package com.amazon_clone.amazon.product;

import com.amazon_clone.amazon.product.domain.Product;
import com.amazon_clone.amazon.product.repository.ProductRepository;
import com.amazon_clone.amazon.product.request.ProductAddRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @DisplayName("상품이 추가 되어야한다")
    @Test
    void product_create_O() {
        //given
        ProductAddRequest productAddRequest = new ProductAddRequest("제품", 10, "main.jpg", 10000, "이 제품은 제품 입니다");

        //when

        // <<mock 객체 생성>>
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("제품", 10, "main.jpg", 10000, "이 제품은 제품 입니다"));

        when(productRepository.findAll())
                .thenReturn(products);

        // <<서비스 실행 >>
        productService.add(productAddRequest);

        //then
        Assertions.assertEquals("제품",
                productRepository.findAll().getFirst().getName()
        );
    }

    @DisplayName("제품이 삭제가 되어야한다")
    @Test
    void product_delete_O() {
        //given

        //when
        Long productId = 1L;
        productService.delete(productId);

        // <<mock 객체 생성 >>
        Mockito.when(productRepository.findById(productId))
                .thenReturn(null);

        //then
        Assertions.assertNull(productRepository.findById(productId));
    }
}