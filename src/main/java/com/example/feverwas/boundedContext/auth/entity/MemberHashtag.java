package com.example.feverwas.boundedContext.auth.entity;

import com.example.feverwas.base.entity.BaseEntity;
import com.example.feverwas.boundedContext.hashtag.entity.Hashtag;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class MemberHashtag extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "member_id", nullable = false)
	private Member member;

	@ManyToOne
	@JoinColumn(name = "hashtag_id", nullable = false)
	private Hashtag hashtag;
}
