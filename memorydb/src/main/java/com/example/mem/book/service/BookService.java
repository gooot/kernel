package com.example.mem.book.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.mem.book.db.BookRepository;
import com.example.mem.book.model.BookEntity;

import lombok.RequiredArgsConstructor;

@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository){
		this.bookRepository = bookRepository;
	}


	public BookEntity create(BookEntity book){
		return bookRepository.save(book);
	}


	public List<BookEntity> findAll(){
		return bookRepository.findAll();
	}





}
