package com.donggyo.demo.service;

import com.donggyo.demo.dto.bookinfo.BookInfoDto;
import com.donggyo.demo.dto.page.PagedObjectDto;
import com.donggyo.demo.entity.BookSearchHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BookSearchAggregateService {

	@Autowired
	private BookSearchHistoryService bookSearchHistoryService;
	@Autowired
	private BookSearchService bookSearchService;
	@Autowired
	private KeywordSearchRateService keywordSearchRateService;

	public PagedObjectDto<BookInfoDto> searchBookInfo(String query, String sort, Integer page, Integer size, String target) {

		PagedObjectDto<BookInfoDto> pagedBookInfoDto = bookSearchService.searchBookByQuery(query, sort, page, size, target);

		bookSearchHistoryService.save(new BookSearchHistory(new Random().nextLong(), "userId", query));
		keywordSearchRateService.saveOrUpdate(query);

		return pagedBookInfoDto;
	}
}
