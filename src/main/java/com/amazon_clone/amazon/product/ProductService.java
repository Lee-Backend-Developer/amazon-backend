package com.amazon_clone.amazon.product;

import com.amazon_clone.amazon.product.domain.Product;
import com.amazon_clone.amazon.product.repository.ProductRepository;
import com.amazon_clone.amazon.product.request.ProductAddRequest;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public Page<Product> productPages(PageRequest pageRequest) {
        Page<Product> productList = productRepository.findAll(pageRequest);
        return productList;
    }

    @Transactional
    public Product add(ProductAddRequest productAddRequest) {
        Product saveProduct = Product.builder()
                .name(productAddRequest.getName())
                .description(productAddRequest.getDescription())
                .cnt(productAddRequest.getCnt())
                .mainImage(productAddRequest.getMainImage())
                .price(productAddRequest.getPrice())
                .build();

        return productRepository.save(saveProduct);

    }

    @Transactional
    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }
}
