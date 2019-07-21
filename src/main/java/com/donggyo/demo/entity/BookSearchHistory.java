package com.donggyo.demo.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name =  "book_search_history")
@Entity
@Getter
public class BookSearchHistory {

	@Id
	@Column(name = "book_search_history_id")
	private Long bookSearchHistoryId;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "keyword")
	private String keyword;

	@Column(name = "search_date")
	private LocalDateTime searchDate;

	public BookSearchHistory(Long bookSearchHistoryId, String userId, String keyword) {
		this.bookSearchHistoryId = bookSearchHistoryId;
		this.userId = userId;
		this.keyword = keyword;
		this.searchDate = LocalDateTime.now();
	}
}
