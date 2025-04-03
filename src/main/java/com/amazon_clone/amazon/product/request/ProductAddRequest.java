package com.amazon_clone.amazon.product.request;

public class ProductAddRequest extends ProductRequest {
    public ProductAddRequest() {
    }

    public ProductAddRequest(String name, int cnt, String mainImage, int price, String description) {
        super(name, cnt, mainImage, price, description);
    }
}
