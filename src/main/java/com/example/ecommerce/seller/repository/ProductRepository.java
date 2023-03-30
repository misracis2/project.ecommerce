package com.example.ecommerce.seller.repository;

import com.example.ecommerce.seller.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
