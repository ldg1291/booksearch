package com.donggyo.demo.adapter


import com.donggyo.demo.dto.bookinfo.BookInfoMeta
import com.donggyo.demo.dto.bookinfo.BookSearchResultDto
import org.assertj.core.util.Lists
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

class BookSearchExternalApiAdapterTest extends Specification {
	BookSearchExternalApiAdapter sut
	RestTemplate restTemplate

	void setup() {
		restTemplate = Mock(RestTemplate)
		sut = new BookSearchExternalApiAdapter(restTemplate: restTemplate)
	}

	def "kakao api call success"() {
		given:
		restTemplate.exchange(_,_,_, BookSearchResultDto.class) >> new ResponseEntity<BookSearchResultDto>(new BookSearchResultDto(documents: Lists.newArrayList(), meta:new BookInfoMeta(is_end: true, pageable_count: 0, total_count: 0)),HttpStatus.OK)

		when:
		def res = sut.getBook("query")

		then:
		res.statusCode == HttpStatus.OK
		res.body.meta.is_end
		res.body.meta.total_count == 0
		res.body.meta.pageable_count == 0

	}
}
