package com.amazon_clone.amazon.member.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberLoginResponse {
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final String address;

    @Builder
    public MemberLoginResponse(String name, String email, String phoneNumber, String address) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
