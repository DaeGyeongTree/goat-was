package com.example.feverwas.boundedContext.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.feverwas.boundedContext.auth.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
