package com.pilipenko.homework.repository;

import com.pilipenko.homework.model.Author;
import com.pilipenko.homework.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book getBookByName (String name);
}
