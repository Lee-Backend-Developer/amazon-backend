package com.amazon_clone.amazon.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public class Response {

    private Object response;
    private HttpStatus status;

    public Response(Object response, HttpStatus status) {
        this.response = response;
        this.status = status;
    }
}
