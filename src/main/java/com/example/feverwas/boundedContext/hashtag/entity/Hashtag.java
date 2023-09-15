package com.example.feverwas.boundedContext.hashtag.entity;

import com.example.feverwas.base.entity.BaseEntity;

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
public class Hashtag extends BaseEntity {
	private String tag;

	@Builder
	public Hashtag(String tag) {
		this.tag = tag;
	}
}
