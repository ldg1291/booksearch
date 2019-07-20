package com.donggyo.demo.controller;

import com.donggyo.demo.dto.BookSearchUserCreateRequestDto;
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
	public ResponseDto<BookSearchUserDto> createUser (@RequestBody BookSearchUserCreateRequestDto requestDto) {
		return bookSearchUserService.createUser(requestDto);
	}
}
