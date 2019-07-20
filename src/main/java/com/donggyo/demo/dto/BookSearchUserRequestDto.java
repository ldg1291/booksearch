package com.donggyo.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookSearchUserRequestDto {

	private String userId;
	private String password;
}
