package com.azhagar.repository.impl;

import javax.persistence.EntityManager;

import com.azhagar.entity.Book;
import com.azhagar.repository.BookRepository;

public class BookRepositoryImpl extends BaseRepsitoryImpl<Book, Integer> implements BookRepository {

	public BookRepositoryImpl( EntityManager em) {
		super(Book.class, em);
	}

}
