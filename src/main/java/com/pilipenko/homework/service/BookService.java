package com.pilipenko.homework.service;

import com.pilipenko.homework.DTO.BookDTO;
import com.pilipenko.homework.model.Book;

import java.util.List;

public interface BookService {
    List<String> findAllBooks();
    Book getBookByName(String bookName);
}
