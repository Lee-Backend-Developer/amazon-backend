package com.amazon_clone.amazon.product.domain;

import com.amazon_clone.amazon.category.domain.Category;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
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

    @ManyToOne(fetch = FetchType.LAZY)
    private Category categoryFk;

    @Builder
    public Product(String name, int cnt, String mainImage, int price, String description, Category categoryFk) {
        this.name = name;
        this.cnt = cnt;
        this.mainImage = mainImage;
        this.price = price;
        this.description = description;
        this.categoryFk = categoryFk;
    }
}
