package com.amazon_clone.amazon.member.dto.request;

public class MemberLogin extends MemberRequest {

    public MemberLogin() {
    }

    public MemberLogin(String email, String password) {
        super(email, password);
    }
}
