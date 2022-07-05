package com.pilipenko.homework.repository;

import com.pilipenko.homework.model.Author;
import com.pilipenko.homework.model.Book;

import java.util.List;

public interface AuthorRepositoryCustom {
    List<Author> nameAuthorsHasMin3BooksCostGreaterThan2000();
}
