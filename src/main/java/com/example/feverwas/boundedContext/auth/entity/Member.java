package com.example.feverwas.boundedContext.auth.entity;

import com.example.feverwas.base.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Member extends BaseEntity {
	@Column(length = 100, nullable = false, unique = true)
	private String username;

	@Column(length = 50, nullable = false)
	private String nickname;

	@Builder
	public Member(String username, String nickname) {
		this.username = username;
		this.nickname = nickname;
	}
}
