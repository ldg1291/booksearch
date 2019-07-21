package com.donggyo.demo.service;

import com.donggyo.demo.entity.KeywordSearchRate;
import com.donggyo.demo.repository.KeywordSearchRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordSearchRateService {

	private static final Long FIRST_SEARCH = 1L;

	@Autowired
	private KeywordSearchRateRepository keywordSearchRateRepository;

	public void saveOrUpdate(String keyword) {
		KeywordSearchRate keywordSearchRate = keywordSearchRateRepository.findByKeyword(keyword);

		if (keywordSearchRate != null) {
			keywordSearchRateRepository.save(new KeywordSearchRate(keyword, keywordSearchRate.getSearchNumber()+1));
		} else {
			keywordSearchRateRepository.save(new KeywordSearchRate(keyword, FIRST_SEARCH));
		}
	}

	public List<KeywordSearchRate> getTop10MostSearchedKeywords() {
		return keywordSearchRateRepository.findTop10ByOrderBySearchNumberDesc();
	}
}
