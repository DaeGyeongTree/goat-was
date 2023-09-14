package com.example.feverwas.boundedContext.auth.entity;

import com.example.feverwas.base.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member extends BaseEntity {
	@Column(length = 100, nullable = false, unique = true)
	private String email;

	@Column(length = 50, nullable = false)
	private String nickname;

	@Builder
	public Member(String email, String nickname) {
		this.email = email;
		this.nickname = nickname;
	}
}
