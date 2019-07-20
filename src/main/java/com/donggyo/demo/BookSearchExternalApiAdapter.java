package com.donggyo.demo;

import com.donggyo.demo.dto.bookinfo.BookSearchResultDto;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class BookSearchExternalApiAdapter {

	@Value("${kakao.api.search.url}")
	private String kakaoSearchUrl;
	@Value("${kakao.api.key}")
	private String kakaoApiKey;

	@Autowired
	private RestTemplate restTemplate;

	public ResponseEntity<BookSearchResultDto> getBook(String query) {
		String queryParam = queryBuilder(query);

		return restTemplate.exchange(queryParam, HttpMethod.GET, makeHttpEntity(), BookSearchResultDto.class);
	}

	private HttpEntity<Map<String, String>> makeHttpEntity() {

		MultiValueMap<String, String> header =
			new LinkedMultiValueMap(Maps.newHashMap(new ImmutableMap.Builder<String, List<String>>().put("Authorization", Lists.newArrayList("KakaoAK " + kakaoApiKey)).build()));

		return new HttpEntity<>(header);
	}

	private String queryBuilder(String query) {
		StringBuilder stringBuilder = new StringBuilder(kakaoSearchUrl);

		if(!StringUtils.isEmpty(query)) {
			stringBuilder.append("query=").append(query);
		}

		return stringBuilder.toString();
	}
}
