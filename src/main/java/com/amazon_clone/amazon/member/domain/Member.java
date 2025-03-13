package com.amazon_clone.amazon.member.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
@RequiredArgsConstructor
@Entity
public class Member {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;
    private String phoneNumber;
    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Member(String name, String phoneNumber, String address, Role role) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.role = Objects.isNull(role) ? Role.USER : role;
    }
}
