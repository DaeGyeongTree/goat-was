package com.example.feverwas.boundedContext.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.feverwas.boundedContext.auth.entity.MemberHashtag;

public interface MemberHashtagRepository extends JpaRepository<MemberHashtag, Long> {
}
