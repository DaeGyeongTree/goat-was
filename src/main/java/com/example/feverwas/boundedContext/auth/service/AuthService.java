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

	}
}
