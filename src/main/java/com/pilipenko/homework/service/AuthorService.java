package com.pilipenko.homework.service;

import com.pilipenko.homework.model.Author;

import java.util.List;

public interface AuthorService {
    List<String> findAllAuthors();
    List<String> findAllBooksByAuthor(String author);
    Integer totalCostBooksOf(String authorName);
    List<Author> getSomeAuthors ();
    List<Author> getIgors();
}
