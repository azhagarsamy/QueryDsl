package com.azhagar.repository;

import java.util.List;
import java.util.Optional;

import com.azhagar.dto.AuthorStatistic;
import com.azhagar.entity.Author;

public interface AuthorRepository extends BaseRepository<Author, Integer> {

//	Optional<Author> findAuthorByEmail(String email);
//	
//	List<AuthorStatistic> getAuthorStatistic();
//	
//	List<Author> getAuthors();
	public Optional<Author> findAuthorByEmail(String email);

	public List<AuthorStatistic> getAuthorStatistic();

	public List<Author> getAuthors();

}
