package com.example.ecommerce.seller.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String content;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    private int commission;

    public Product(String title, String content, int price, int stock, int commission) {
        this.title = title;
        this.content = content;
        this.price = price;
        this.stock = stock;
        this.commission = commission;
    }
}
