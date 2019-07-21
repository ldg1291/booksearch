package com.donggyo.demo.repository;

import com.donggyo.demo.entity.BookSearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookSearchHistoryRepository extends JpaRepository<BookSearchHistory, Long> {

	List<BookSearchHistory> findTop10ByUserIdOrderBySearchDateDesc(String userId);
}
