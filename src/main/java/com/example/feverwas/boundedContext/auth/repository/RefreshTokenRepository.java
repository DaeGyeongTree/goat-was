package com.example.feverwas.boundedContext.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.example.feverwas.boundedContext.auth.entity.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
	void deleteByUsername(String userEmail);

	Optional<RefreshToken> findByUsername(String username);

}
