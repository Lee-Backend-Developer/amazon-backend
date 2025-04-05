package com.amazon_clone.amazon.category.response;

import com.amazon_clone.amazon.common.Response;
import org.springframework.http.HttpStatus;

public class CategoryResponse extends Response {
    public CategoryResponse(Object response, HttpStatus status) {
        super(response, status);
    }
}
