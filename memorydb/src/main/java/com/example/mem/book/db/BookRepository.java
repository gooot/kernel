package com.example.mem.book.db;

import org.springframework.stereotype.Service;

import com.example.mem.book.model.BookEntity;
import com.example.mem.db.SimpleDataRepository;


@Service
public class BookRepository extends SimpleDataRepository<BookEntity,Long> {
}
