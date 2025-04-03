package com.amazon_clone.amazon.product;

import com.amazon_clone.amazon.common.Response;
import com.amazon_clone.amazon.product.domain.Product;
import com.amazon_clone.amazon.product.request.ProductAddRequest;
import com.amazon_clone.amazon.product.request.ProductRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    // 제품 생성
    @PutMapping("add")
    public ResponseEntity<Response> addProduct(@RequestBody ProductAddRequest request) {
        Product product = productService.add(request);
        Response response = new Response(product, HttpStatus.CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    // 제품 조회
    @GetMapping
    public ResponseEntity<Response> products() {
        Page<Product> products = productService.productPages(PageRequest.of(0, 10));
        Response response = new Response(products, HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 제품 삭제
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Response> deleteProduct(@PathVariable Long id){
        productService.delete(id);
        Response response = new Response(null, HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
