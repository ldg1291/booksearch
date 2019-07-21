package com.donggyo.demo.service;

import com.donggyo.demo.adapter.BookSearchExternalApiAdapter;
import com.donggyo.demo.dto.bookinfo.BookInfoDto;
import com.donggyo.demo.dto.bookinfo.BookInfoMeta;
import com.donggyo.demo.dto.bookinfo.BookSearchResultDto;
import com.donggyo.demo.dto.page.PagedObjectDto;
import com.donggyo.demo.dto.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookSearchService {
	@Autowired
	private BookSearchExternalApiAdapter bookSearchExternalApiAdapter;

	PagedObjectDto<BookInfoDto> searchBookByQuery(String query, String sort, Integer page, Integer size, String target) {

		BookSearchResultDto bookSearchResultDto = bookSearchExternalApiAdapter.getBook(query, sort, page, size, target);

		BookInfoMeta meta = bookSearchResultDto.getMeta();
		List<BookInfoDto> bookInfoDtos = bookSearchResultDto.getDocuments();

		return PagedObjectDto.of(new Pagination(page, size, meta.getPageable_count()), bookInfoDtos);
	}
}
