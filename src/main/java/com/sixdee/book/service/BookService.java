package com.sixdee.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sixdee.book.model.Book;
import com.sixdee.book.repository.BookRepo;
import com.sixdee.book.specification.PagedResponse;

@Service
public class BookService 
{
	@Autowired
	private BookRepo repo;

	public BookService(BookRepo repo) {
		super();
		this.repo = repo;
	}

	public BookService() {
		super();
	}

	public void addBook(Book b)
	{
		repo.save(b);
	}
	
	public PagedResponse<Book> findAllBooks(Pageable p , Specification<Book> spec) 
	{
		return (PagedResponse<Book>) repo.findAll(spec, p);
	}
}
