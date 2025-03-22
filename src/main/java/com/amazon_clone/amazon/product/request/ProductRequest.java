package com.amazon_clone.amazon.product.request;

import lombok.Getter;

@Getter
public abstract class ProductRequest {
    private String name;
    private int cnt;
    private String mainImage;
    private int price;
    private String description;

    // 제품을 생성
    public ProductRequest(String name, int cnt, String mainImage, int price, String description) {
        this.name = name;
        this.cnt = cnt;
        this.mainImage = mainImage;
        this.price = price;
        this.description = description;
    }
}
