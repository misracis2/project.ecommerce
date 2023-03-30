package com.example.ecommerce.global.member.repository;

import com.example.ecommerce.global.member.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    boolean existsByMemberId(String memberId);
}
