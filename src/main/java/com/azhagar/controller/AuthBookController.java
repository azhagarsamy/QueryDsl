package com.azhagar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azhagar.dto.AuthorStatistic;
import com.azhagar.entity.Author;
import com.azhagar.entity.Book;
import com.azhagar.service.AuthBookService;

@RestController
@RequestMapping("/rest")
public class AuthBookController {

	@Autowired
	private AuthBookService service;

	@PostMapping("/authors/save")
	public List<Author> saveAuthorwithBooks(@RequestBody List<Author> authors) {
		return service.saveAuthorwithBooks(authors);
	}

//  will find N+1 problem in hibernate/jpa
	@GetMapping("/authors")
	public List<Author> getAuthors() {
		return service.getAuthors();
	}

	@GetMapping("/authors/books")
	public List<Book> getBooks() {
		return service.getBooks();
	}

	@GetMapping("/authors/{email}")
	public Optional<Author> findAuthorByemail(@PathVariable String email) {
		return service.findAuthorByemail(email);
	}

	@GetMapping("/authors/getAuthorStatistics")
	public List<AuthorStatistic> getAuthorStatistics() {
		return service.getAuthorStatistics();
	}

	@GetMapping("/authors/getAuthorswithFetchJoin")
	public List<Author> getAuthorswithFetchJoin() {
		return service.getAuthorswithFetchJoin();
	}

}
