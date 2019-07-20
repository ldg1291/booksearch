package com.donggyo.demo.dto.bookinfo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class BookSearchResultDto {

	private List<BookInfoDto> documents;
	private BookInfoMeta meta;
}
