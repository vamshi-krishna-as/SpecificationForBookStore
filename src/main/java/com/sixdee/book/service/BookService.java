package com.sixdee.book.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sixdee.book.model.Book;
import com.sixdee.book.specification.PagedResponse;

public interface BookService 
{
	public PagedResponse<Book> findAllBooks(Pageable pageable, Specification<Book> spec);

	public void addBook(Book book);
}
