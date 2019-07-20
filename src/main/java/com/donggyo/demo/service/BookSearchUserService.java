package com.donggyo.demo.service;

import com.donggyo.demo.repository.BookSearchUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookSearchUserService {

	@Autowired
	private BookSearchUserRepository bookSearchUserRepository;

	private boolean checkIfUserExists(String userId) {
		return bookSearchUserRepository.existsByUserId(userId);
	}
}
