package com.amazon_clone.amazon.product;

import com.amazon_clone.amazon.product.domain.Product;
import com.amazon_clone.amazon.product.repository.ProductRepository;
import com.amazon_clone.amazon.product.request.ProductAddRequest;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public void add(ProductAddRequest productAddRequest) {
        Product saveProduct = Product.builder()
                .name(productAddRequest.getName())
                .description(productAddRequest.getDescription())
                .cnt(productAddRequest.getCnt())
                .mainImage(productAddRequest.getMainImage())
                .price(productAddRequest.getPrice())
                .build();

        productRepository.save(saveProduct);

    }

    @Transactional
    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }
}
