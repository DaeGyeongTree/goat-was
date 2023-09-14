package com.example.feverwas.base.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "jwt")
@Getter
@Setter
public class JwtConfig {
	private String secretKey;
	private Long expirationTime;
	private String tokenPrefix;
	private String headerString;
	private String issuer;
}
