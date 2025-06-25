package com.amazon_clone.amazon.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberSessionInfo {
    private String name;
    private String email;
    private String phoneNumber;
}
