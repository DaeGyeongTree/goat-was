package com.example.feverwas.boundedContext.auth.service;

import java.net.MalformedURLException;

import org.springframework.stereotype.Service;

import com.example.feverwas.base.jwt.dto.TokenDto;
import com.example.feverwas.base.jwt.util.JwtProvider;
import com.example.feverwas.boundedContext.auth.dto.OAuthInfo;
import com.example.feverwas.boundedContext.auth.entity.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	private final KakaoService kakaoService;
	private final MemberService memberService;
	private final JwtProvider jwtProvider;
	private final RefreshTokenService refreshTokenService;

	public String getAuthorizationUrl() {
		return kakaoService.getAuthorizationUrl();
	}

	public TokenDto login(String accessToken) throws MalformedURLException {
		// 카카오 계정 정보 가져오기
		// TokenDto kakaoToken = kakaoService.getToken(code);
		OAuthInfo oAuthInfo = kakaoService.getUserInfo(accessToken);

		// DB에 존재하지 않을 경우 저장
		Member savedMember;

		if (!memberService.isExist(oAuthInfo.getEmail())) {
			Member member = Member.builder()
							.username(oAuthInfo.getEmail())
							.nickname(oAuthInfo.getNickname())
							.build();
			savedMember = memberService.create(member);
		} else {
			savedMember = memberService.read(oAuthInfo.getEmail());
		}

		// JWT 토큰 발급
		TokenDto tokenDto = TokenDto.builder()
				.accessToken(jwtProvider.generateToken(oAuthInfo.getEmail(), savedMember.getId()))
				.refreshToken(jwtProvider.generateRefreshToken(oAuthInfo.getEmail(), savedMember.getId()))
				.build();

		// Refresh Token 저장
		refreshTokenService.storeRefreshToken(tokenDto, savedMember.getUsername());

		// JWT 전송
		return TokenDto.builder()
				.accessToken(jwtProvider.generateToken(oAuthInfo.getEmail(), savedMember.getId()))
				.refreshToken(jwtProvider.generateRefreshToken(oAuthInfo.getEmail(), savedMember.getId()))
				.build();
	}

	public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String accessToken = jwtProvider.resolveToken(request);
		String username = jwtProvider.getUsername(accessToken);
		refreshTokenService.deleteRefreshToken(username);
	}
}
