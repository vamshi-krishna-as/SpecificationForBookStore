package com.sixdee.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sixdee.book.model.Book;

public interface BookRepo extends PagingAndSortingRepository<Book, Integer> , JpaSpecificationExecutor<Book>
{

}
