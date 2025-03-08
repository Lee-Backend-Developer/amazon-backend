package com.amazon_clone.amazon.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;
    private int cnt;
    private String mainImage;
    private int price;
    private String description;

    @Builder
    public Product(String name, int cnt, String mainImage, int price, String description) {
        this.name = name;
        this.cnt = cnt;
        this.mainImage = mainImage;
        this.price = price;
        this.description = description;
    }
}
