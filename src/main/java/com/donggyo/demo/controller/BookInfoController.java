package com.donggyo.demo.controller;

import com.donggyo.demo.dto.bookinfo.BookInfoDto;
import com.donggyo.demo.dto.page.PagedObjectDto;
import com.donggyo.demo.service.BookSearchAggregateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookInfoController {

	@Autowired
	private BookSearchAggregateService bookSearchAggregateService;

	@GetMapping("/search")
	@ResponseBody
	public PagedObjectDto<BookInfoDto> getBook(@RequestParam(required = true)String query, @RequestParam(required = false) String sort, @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size, @RequestParam(required = false) String target) {
		return bookSearchAggregateService.searchBookInfo(query, sort, page, size, target);
	}
}
