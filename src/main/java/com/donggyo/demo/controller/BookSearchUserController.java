package com.donggyo.demo.controller;

import com.donggyo.demo.dto.BookSearchUserRequestDto;
import com.donggyo.demo.dto.BookSearchUserDto;
import com.donggyo.demo.dto.ResponseDto;
import com.donggyo.demo.service.BookSearchUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BookSearchUserController {

	@Autowired
	private BookSearchUserService bookSearchUserService;

	@PostMapping("/user/create")
	public ResponseDto<BookSearchUserDto> createUser (@RequestBody BookSearchUserRequestDto requestDto) {
		return bookSearchUserService.createUser(requestDto);
	}

	@PostMapping("/user/login")
	public ResponseDto logInUser(@RequestBody BookSearchUserRequestDto requestDto) {
		return bookSearchUserService.logInWithUser(requestDto);
	}
}
