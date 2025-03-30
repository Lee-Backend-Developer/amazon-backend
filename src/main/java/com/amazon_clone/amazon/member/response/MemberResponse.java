package com.amazon_clone.amazon.member.response;

import com.amazon_clone.amazon.common.Response;
import org.springframework.http.HttpStatus;

public class MemberResponse extends Response {
    public MemberResponse(Object response, HttpStatus status) {
        super(response, status);
    }
}
