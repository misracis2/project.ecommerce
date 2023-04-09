package com.example.ecommerce.global.member.repository;

import com.example.ecommerce.global.member.model.Customer;
import com.example.ecommerce.global.member.model.MemberGrade;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByMemberId(String memberId);

    List<Customer> findByMemberGrade(MemberGrade memberGrade, Pageable pageable);



}
