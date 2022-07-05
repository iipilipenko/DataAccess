package com.pilipenko.homework.service.Impl;

import com.pilipenko.homework.DTO.BookDTO;
import com.pilipenko.homework.model.Book;
import com.pilipenko.homework.repository.BookRepository;
import com.pilipenko.homework.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {


    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<String> findAllBooks() {
        try {
            List<Book> bookList = bookRepository.findAll();
            return bookList.stream()
                    .map(Book::getName)
                    .collect(Collectors.toList());
        } catch (NullPointerException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Book getBookByName(String bookName) {
        return bookRepository.getBookByName(bookName);
    }
}
