package com.amazon_clone.amazon.category;

import com.amazon_clone.amazon.product.Product;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Category {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    @OneToMany
    private List<Product> products = new ArrayList<>();


    @Builder
    public Category(String name) {
        this.name = name;
    }
}
