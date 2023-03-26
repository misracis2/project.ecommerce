package com.example.ecommerce.global.member;

import com.example.ecommerce.global.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpRepository extends JpaRepository<Member, Long> {
    boolean existsByMemberId(String memberId);

}
