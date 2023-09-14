package com.example.feverwas.boundedContext.auth.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	private final KakaoService kakaoService;
	private final MemberService memberService;

	public String getAuthorizationUrl() {
		return kakaoService.getAuthorizationUrl();
	}

	public void login() {
		// 콜백을 통해 성공 여부 정함

		// DB에 존재하지 않을 경우 저장

		// JWT 토큰 발급
	}
}
