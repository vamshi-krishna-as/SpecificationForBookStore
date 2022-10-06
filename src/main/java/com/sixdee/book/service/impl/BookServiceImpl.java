package com.sixdee.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sixdee.book.model.Book;
import com.sixdee.book.repository.BookRepo;
import com.sixdee.book.service.BookService;
import com.sixdee.book.specification.PagedResponse;

@Service
public class BookServiceImpl implements BookService
{
	@Autowired
	private BookRepo repo;


	public void addBook(Book b)
	{
		repo.save(b);
	}


	public PagedResponse<Book> findAllBooks(Pageable pageable, Specification<Book> spec) {	
	Page<Book> entity =repo.findAll(spec, pageable);
	
	return new PagedResponse<>(entity.getContent(), entity.getNumber(), entity.getSize(),
	        entity.getTotalElements(), entity.getTotalPages(), entity.isLast());
	    
	}
	
	@Override
	public void deleteById(int bookId) {
		repo.deleteById(bookId);
	}
}
