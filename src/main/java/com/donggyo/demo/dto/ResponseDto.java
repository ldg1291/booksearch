package com.donggyo.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseDto<T> {

	private static final String EMPTY_STRING = "";
	private T data;
	private boolean success;
	private String message;

	public ResponseDto (T data) {
		this.data = data;
		this.success = Boolean.TRUE;
		this.message = EMPTY_STRING;
	}

	private ResponseDto (boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public static ResponseDto failResponseOf(String message) {
		return new ResponseDto(Boolean.FALSE, message);
	}
}
