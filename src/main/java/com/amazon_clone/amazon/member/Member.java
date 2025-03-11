package com.amazon_clone.amazon.member;

import jakarta.persistence.*;

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

}
