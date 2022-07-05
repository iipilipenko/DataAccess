package com.pilipenko.homework.service.Impl;

import com.pilipenko.homework.model.Author;
import com.pilipenko.homework.model.Book;
import com.pilipenko.homework.repository.AuthorRepository;
import com.pilipenko.homework.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<String> findAllAuthors() {
        try {
            List<Author> authors = authorRepository.findAll();
            return authors.stream()
                    .map(Author::getName)
                    .collect(Collectors.toList());
        } catch (NullPointerException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<String> findAllBooksByAuthor(String author) {
        try {
            List<Book> bookList = authorRepository.getAuthorByName(author).getBooks();
            return bookList.stream()
                    .map(book -> book.getName())
                    .collect(Collectors.toList());
        } catch (NullPointerException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Integer totalCostBooksOf(String authorName) {
        return authorRepository.getAuthorByName(authorName)
                .getBooks().stream()
                .mapToInt(Book::getPrice)
                .sum();

    }

    @Override
    public List<Author> getIgors() {
        return authorRepository.getAuthorIgorNative();
    }

    @Override
    public List<Author> getSomeAuthors() {
        return authorRepository.nameAuthorsHasMin3BooksCostGreaterThan2000();
    }
}
