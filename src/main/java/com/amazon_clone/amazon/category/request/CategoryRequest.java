package com.amazon_clone.amazon.category.request;

import lombok.Data;

@Data
public class CategoryRequest {
    private String name;

    public CategoryRequest() {
    }
    // 카테고리 생성
    public CategoryRequest(String name) {
        this.name = name;
    }
}
