package com.example.feverwas.boundedContext.auth.api;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RequestMapping("/auth")
@Tag(name = "Auth", description = "사용자 인증 관련 API")
public interface AuthApi {
	@GetMapping("/login")
	@Operation(summary = "카카오 로그인 메서드", description = "카카오 로그인을 하기 위한 메서드입니다.")
	void kakaoLogin(HttpServletRequest request, HttpServletResponse response);

	@PostMapping("logout")
	@Operation(summary = "로그아웃 메서드", description = "로그아웃을 하기 위한 메서드입니다.")
	void logout(HttpServletRequest request, HttpServletResponse response);
}
