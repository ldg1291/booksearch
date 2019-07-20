package com.donggyo.demo.service;

import com.donggyo.demo.dto.BookSearchUserCreateRequestDto;
import com.donggyo.demo.dto.BookSearchUserDto;
import com.donggyo.demo.dto.ResponseDto;
import com.donggyo.demo.entity.BookSearchUser;
import com.donggyo.demo.repository.BookSearchUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookSearchUserService {

	private static final String ALREADY_EXISTS_USER = "이미 존재하는 ID입니다. 다른 아이디를 사용해주세요";

	@Autowired
	private BookSearchUserRepository bookSearchUserRepository;

	public ResponseDto<BookSearchUserDto> createUser(BookSearchUserCreateRequestDto requestDto) {

		if (checkIfUserExistsWithUserId(requestDto.getUserId())) {
			return ResponseDto.failResponseOf(ALREADY_EXISTS_USER);
		}

		BookSearchUser newUser = makeBookSearchUser(requestDto);
		BookSearchUserDto newUserDto = tranformFrom(newUser);

		return new ResponseDto<>(newUserDto);
	}

	private boolean checkIfUserExistsWithUserId(String userId) {
		return bookSearchUserRepository.existsByUserId(userId);
	}

	private BookSearchUser makeBookSearchUser(BookSearchUserCreateRequestDto requestDto) {

		LocalDateTime nowDate = LocalDateTime.now();

		return new BookSearchUser(requestDto.getUserId(), requestDto.getPassword(), nowDate, nowDate);
	}

	private BookSearchUserDto tranformFrom(BookSearchUser bookSearchUser) {
		return new BookSearchUserDto(bookSearchUser.getUserId(), bookSearchUser.getCreatedAt(), bookSearchUser.getModifiedAt());
	}
}
