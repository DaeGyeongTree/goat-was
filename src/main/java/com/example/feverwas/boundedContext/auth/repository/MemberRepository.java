package com.example.feverwas.boundedContext.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.feverwas.boundedContext.auth.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Optional<Member> findByUsername(String username);
	boolean existsByUsername(String username);
}
