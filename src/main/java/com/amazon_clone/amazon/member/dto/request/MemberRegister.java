package com.amazon_clone.amazon.member.dto.request;

import com.amazon_clone.amazon.member.domain.Role;
import lombok.Builder;

public class MemberRegister extends MemberRequest {

    public MemberRegister() {
    }

    @Builder
    public MemberRegister(String email, String password, String name, String phoneNumber, String address, Role role) {
        super(email, password, name, phoneNumber, address, role);
    }
}
