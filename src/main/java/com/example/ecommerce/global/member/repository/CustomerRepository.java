package com.example.ecommerce.global.member.repository;

import com.example.ecommerce.global.member.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByMemberId(String memberId);

}
