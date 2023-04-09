package com.azhagar.repository.impl;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.azhagar.entity.QAuthor;
import com.azhagar.entity.QBook;
import com.azhagar.repository.BaseRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;


public abstract class BaseRepsitoryImpl<T,ID> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID>  {
	
	EntityManager em;
	JPAQueryFactory jpaQueryFactory;
	
	protected final QAuthor author=QAuthor.author;
	protected final QBook book=QBook.book;

	public BaseRepsitoryImpl(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		this.em=em;
		this.jpaQueryFactory=new JPAQueryFactory(em);
	}

	@Override
	public T findByIdMan(ID id) throws IllegalArgumentException {
		return findById(id).orElseThrow(()->new IllegalArgumentException("entity not found with id"+id));
	}
	
	
	

}
