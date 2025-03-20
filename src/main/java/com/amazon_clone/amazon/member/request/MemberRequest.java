package com.amazon_clone.amazon.member.request;

import com.amazon_clone.amazon.member.domain.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
public abstract class MemberRequest {
    private String email;
    private String password;
    private String name;
    private String phoneNumber;
    private String address;
    private Role role;

    // 로그인
    public MemberRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // 회원가입
    public MemberRequest(String name, String phoneNumber, String address, Role role) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.role = role;
    }
}
