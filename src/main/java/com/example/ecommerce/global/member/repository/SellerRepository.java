package com.example.ecommerce.global.member.repository;

import com.example.ecommerce.global.member.model.MemberGrade;
import com.example.ecommerce.global.member.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    boolean existsByMemberId(String memberId);

    List<Seller> findByMemberGrade(MemberGrade memberGrade);
}
