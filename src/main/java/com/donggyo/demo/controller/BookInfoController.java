package com.donggyo.demo.controller;

import com.donggyo.demo.BookSearchExternalApiAdapter;
import com.donggyo.demo.dto.bookinfo.BookSearchResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookInfoController {

	@Autowired
	private BookSearchExternalApiAdapter bookSearchExternalApiAdapter;

	@GetMapping("/search")
	public ResponseEntity<BookSearchResultDto> getBook(@RequestParam(required = true)String query) {
		return bookSearchExternalApiAdapter.getBook(query);
	}
}
