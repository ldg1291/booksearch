package com.donggyo.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class BookSearchUserRequestDto implements Serializable {

	private String userId;
	private String password;
}
