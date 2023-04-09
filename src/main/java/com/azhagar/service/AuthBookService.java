package com.azhagar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azhagar.dto.AuthorStatistic;
import com.azhagar.entity.Author;
import com.azhagar.entity.Book;
import com.azhagar.repository.AuthorRepository;
import com.azhagar.repository.BookRepository;

@Service
public class AuthBookService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	
	public List<Author> saveAuthorwithBooks(List<Author>authors){
		return authorRepository.saveAll(authors);
	}
//  will find N+1 problem in hibernate/jpa
	public List<Author> getAuthors(){
		return authorRepository.findAll();
	}
	
	public List<Book> getBooks(){
		return bookRepository.findAll();
	}
	
   public Optional<Author> findAuthorByemail(String email){
	   return authorRepository.findAuthorByEmail(email);
   }
   public List<AuthorStatistic> getAuthorStatistics(){
	   return authorRepository.getAuthorStatistic();
   }
   
   public List<Author> getAuthorswithFetchJoin(){
	   return authorRepository.getAuthors();
   }

}
