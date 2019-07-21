package com.donggyo.demo.service;

import com.donggyo.demo.dto.BookSearchHistoryDto;
import com.donggyo.demo.entity.BookSearchHistory;
import com.donggyo.demo.repository.BookSearchHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookSearchHistoryService {

	@Autowired
	private BookSearchHistoryRepository bookSearchHistoryRepository;

	public List<BookSearchHistoryDto> findRecentHistories (String userId) {
		return findTop10ByUserIdOrderBySearchDateDesc(userId).stream().map(this::transformTo).collect(Collectors.toList());
	}

	BookSearchHistory save(BookSearchHistory history) {
		return bookSearchHistoryRepository.save(history);
	}

	private List<BookSearchHistory> findTop10ByUserIdOrderBySearchDateDesc(String userId) {
		return bookSearchHistoryRepository.findTop10ByUserIdOrderBySearchDateDesc(userId);
	}

	private BookSearchHistoryDto transformTo(BookSearchHistory bookSearchHistory) {
		return new BookSearchHistoryDto(bookSearchHistory.getUserId(), bookSearchHistory.getKeyword(), bookSearchHistory.getSearchDate());
	}
}
