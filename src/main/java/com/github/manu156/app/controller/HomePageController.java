package com.github.manu156.app.controller;

import com.github.manu156.app.repository.BookRepository;
import com.github.manu156.app.service.HomeService;
import com.github.manu156.app.service.LibraryService;
import com.github.manu156.app.service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/home")
public class HomePageController {

	@Autowired
	private OauthService oauthService;

	@Autowired
	private HomeService homeService;


	@GetMapping("/myBooks")
	public List<String> myBooks(@RequestParam Long userId) {
		oauthService.verifyUser(userId);
		return homeService.getMyBooks(userId);
	}

	@GetMapping("/suggestions")
	public List<String> suggestions(@RequestParam Long userId) {
		oauthService.verifyUser(userId);
		return homeService.getSuggestions(userId);
	}
}
