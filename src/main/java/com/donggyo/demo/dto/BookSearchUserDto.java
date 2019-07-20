package com.donggyo.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BookSearchUserDto {

	private String userId;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;

	public BookSearchUserDto (String userId, LocalDateTime createdAt, LocalDateTime modifiedAt) {
		this.userId = userId;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}
}
