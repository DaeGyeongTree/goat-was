package com.example.feverwas.boundedContext.auth.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.feverwas.base.jwt.dto.TokenDto;
import com.example.feverwas.boundedContext.auth.config.KakaoConfig;
import com.example.feverwas.boundedContext.auth.dto.OAuthInfo;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KakaoService {
	private final KakaoConfig kakaoConfig;

	/**
	 * 카카오 로그인 페이지로 이동하기 위한 url을 반환한다.
	 * @return
	 */
	public String getAuthorizationUrl() {
		return UriComponentsBuilder
				.fromUriString(kakaoConfig.getAuthorizationUri())
				.queryParam("client_id", kakaoConfig.getClientId())
				.queryParam("redirect_uri", kakaoConfig.getRedirectUri())
				.queryParam("response_type", "code")
				.build()
				.toString();
	}

	/**
	 * 카카오 로그인을 통해 얻은 code를 이용하여 access token과 refresh token을 얻는다.
	 * @param code
	 * @return
	 * @throws MalformedURLException
	 */
	public TokenDto getToken(String code) throws MalformedURLException {
		TokenDto tokenDto = null;
		try {
			URL url = new URL(kakaoConfig.getTokenUri());
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();

			conn.setRequestMethod("POST");
			conn.setDoOutput(true);

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();

			sb.append("grant_type=authorization_code");
			sb.append("&client_id=" + kakaoConfig.getClientId());
			sb.append("&redirect_uri=" + kakaoConfig.getRedirectUri());
			sb.append("&code=" + code);
			bw.write(sb.toString());
			bw.flush();

			int responseCode = conn.getResponseCode();

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}

			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);

			String accessToken = element.getAsJsonObject().get("access_token").getAsString();
			String refreshToken = element.getAsJsonObject().get("refresh_token").getAsString();

			br.close();
			bw.close();

			tokenDto = TokenDto.builder()
					.accessToken(accessToken)
					.refreshToken(refreshToken)
					.build();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return tokenDto;
	}

	public OAuthInfo getUserInfo(TokenDto tokenDto) {
		OAuthInfo kakaoAccountInfo = null;

		try {
			URL url = new URL(kakaoConfig.getUserInfoUri());

			HttpURLConnection conn = (HttpURLConnection)url.openConnection();

			conn.setRequestMethod("POST");
			conn.setDoOutput(true);

			conn.setRequestProperty("Authorization", "Bearer " + tokenDto.getAccessToken());

			int responseCode = conn.getResponseCode();

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}

			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);

			String id = Integer.toString(element.getAsJsonObject().get("id").getAsInt());
			String nickname = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("profile").getAsJsonObject().get("nickname").getAsString();
			boolean hasEmail = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("has_email").getAsBoolean();
			String email = null;
			if (hasEmail) {
				email = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("email").getAsString();
			}
			br.close();
			kakaoAccountInfo = kakaoAccountInfo.builder()
					.id(id)
					.email(email)
					.nickname(nickname)
					.build();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return kakaoAccountInfo;
	}
}
