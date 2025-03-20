package com.amazon_clone.amazon.member.request;

import com.amazon_clone.amazon.member.domain.Role;
import lombok.Builder;

public class MemberRegister extends MemberRequest {
    @Builder
    MemberRegister(String name, String phoneNumber, String address, Role role) {
        super(name, phoneNumber, address, role);
    }
}
