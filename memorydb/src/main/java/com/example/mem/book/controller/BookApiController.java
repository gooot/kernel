package com.example.mem.book.controller;

import java.awt.print.Book;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mem.book.model.BookEntity;
import com.example.mem.book.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookApiController {

	private final BookService bookService;


	@PutMapping("")
	public BookEntity create(
		@RequestBody BookEntity bookEntity
	){
		return bookService.create(bookEntity);


	}

	@GetMapping("/all")
	public List<BookEntity> findAll(){
		return bookService.findAll();

	}


	public void delete(
		@RequestBody BookEntity bookEntity
	){
		bookService.delete(bookEntity);

	}

	public


}
