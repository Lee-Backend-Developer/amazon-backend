package com.amazon_clone.amazon.member.request;

import com.amazon_clone.amazon.member.domain.Role;
import lombok.Builder;

public class MemberCreate extends MemberRequest {
    @Builder
    MemberCreate(String name, String phoneNumber, String address, Role role) {
        super(name, phoneNumber, address, role);
    }
}
