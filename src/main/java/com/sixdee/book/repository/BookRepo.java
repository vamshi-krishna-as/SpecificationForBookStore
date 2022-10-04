package com.sixdee.book.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sixdee.book.model.Book;

public interface BookRepo extends PagingAndSortingRepository<Book, Integer>,JpaSpecificationExecutor<Book>
{
	Page<Book> findAll(Specification<Book> spec, Pageable page);
}
