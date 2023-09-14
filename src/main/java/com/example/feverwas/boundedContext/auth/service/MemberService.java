package com.example.feverwas.boundedContext.auth.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.feverwas.boundedContext.auth.entity.Member;
import com.example.feverwas.boundedContext.auth.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;

	public Member create(Member member) {
		return memberRepository.save(member);
	}

	public Member read(Long id) {
		return memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
	}

	public Member read(String username) {
		return memberRepository.findByEmail(username).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
	}

	public boolean isExist(String email) {
		return memberRepository.existsByEmail(email);
	}
}
