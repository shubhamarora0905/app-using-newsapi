package com.newsapp;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.newsapp.bean.NewsAppBean;

@Service
public class NewsConsumerService {

	private static final String apiKey = "fc527386f9f645519ec25092af18a0f0";
	private static String url = "https://newsapi.org/v2/top-headlines?apiKey=API_KEY_TO_REPLACE&country=COUNTRY_TO_REPLACE&category=CATEGORY_TO_REPLACE";

	public NewsAppBean getNews(String country, String category) {
		final String uri = url.replace("API_KEY_TO_REPLACE", apiKey).replace("COUNTRY_TO_REPLACE", country)
				.replace("CATEGORY_TO_REPLACE", category);

		RestTemplate restTemplate = new RestTemplate();
		NewsAppBean result = restTemplate.getForObject(uri, NewsAppBean.class);

		return result;

	}

	public NewsAppBean getNewsSample() {

		String country = "au";
		String category = "sports";
		final String uri = url.replace("API_KEY_TO_REPLACE", apiKey).replace("COUNTRY_TO_REPLACE", country)
				.replace("CATEGORY_TO_REPLACE", category);

		RestTemplate restTemplate = new RestTemplate();
		NewsAppBean result = restTemplate.getForObject(uri, NewsAppBean.class);

		return result;

	}
}
