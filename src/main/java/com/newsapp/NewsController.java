package com.newsapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.newsapp.bean.Article;
import com.newsapp.bean.NewsAppBean;

@RestController
public class NewsController {

	@Autowired
	private NewsConsumerService service;

	@GetMapping("/")
	public ModelAndView getToHome() {

		return new ModelAndView("index", "modelMap", null);
	}

	@GetMapping("/getNews")
	public NewsAppBean getNews(@RequestParam String country, @RequestParam String category) {

		return service.getNews(country, category);
	}

	@GetMapping("/checkAxios")
	public String check() {
		return "{ \"results\": [\r\n"
				+ "      {\"title\": \"the very first post\", \"abstract\": \"lorem ipsum some test dimpsum\"},\r\n"
				+ "      {\"title\": \"and then there was the second\", \"abstract\": \"lorem ipsum some test dimsum\"},\r\n"
				+ "      {\"title\": \"third time's a charm\", \"abstract\": \"lorem ipsum some test dimsum\"},\r\n"
				+ "      {\"title\": \"four the last time\", \"abstract\": \"lorem ipsum some test dimsum\"}\r\n"
				+ "    ]\r\n" + "  }";
	}
	
	@GetMapping("/checkAxiosForArticles")
	public NewsAppBean checkAxiosForArticles() {
		return service.getNewsSample();
	}
}
