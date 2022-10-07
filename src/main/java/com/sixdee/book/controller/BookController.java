package com.sixdee.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sixdee.book.model.Book;
import com.sixdee.book.service.BookService;
import com.sixdee.book.specification.PagedResponse;

import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@RestController
public class BookController {
	
	@Autowired
	private BookService bs;


	@PostMapping("/addBooks")
	public void addBook(@RequestBody Book book) {
		bs.addBook(book);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/getBooks")
	public PagedResponse<Book> getBooks(
			@RequestParam(value = "bookId",required = false) Integer bookId,
			@RequestParam(value = "bookName",required = false) String bookName, 
			@RequestParam(value = "authorName",required = false) String authorName,
			@RequestParam(value = "bookGenre",required = false) String bookGenre, 
			@RequestParam(value = "bookPrice",required = false) Double bookPrice,
			@RequestParam(value = "page", defaultValue = "1",required = false) int page,
			@RequestParam(value = "size", defaultValue = "0",required = false) int size,
			@RequestParam(value = "sort", defaultValue = "createdDate",required = false) String sort,
			@RequestParam(value = "order", defaultValue = "desc", required = false) String order,
			@And({ @Spec(path = "bookId", params = "bookId", spec = Equal.class),
					@Spec(path = "bookGenre", params = "bookGenre", spec = Equal.class),
					@Spec(path = "authorName", params = "authorName", spec = Equal.class) }) 
			Specification<Book> spec) {

		Pageable pageable = (size != 0
				? PageRequest.of(page - 1, size, order.trim().equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,
						sort)
				: Pageable.unpaged());
		return bs.findAllBooks(pageable, spec);
	}

	@GetMapping(value = "/bookPageable")
	Page bookPageable(Pageable pageable)
	{
		return bs.findAll(pageable);
	}
	
	@DeleteMapping("/deleteBooks/{bookId}")
	public int deleteBooks(@PathVariable("bookId") int bookId)
	{
		bs.deleteById(bookId);
		return 0;
	}
	
}
