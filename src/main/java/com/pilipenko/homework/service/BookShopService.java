package com.pilipenko.homework.service;

import com.pilipenko.homework.DTO.AuthorDTO;
import com.pilipenko.homework.DTO.BookDTO;
import com.pilipenko.homework.model.Author;
import com.pilipenko.homework.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookShopService {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    public List<String> getAllAuthors() {
        return authorService.findAllAuthors();
    }

    public List<String> getAllBooks() {
        return bookService.findAllBooks();
    }

    public List<String> getAllBooksFromAuthor(String author) {
        return authorService.findAllBooksByAuthor(author);
    }

    public BookDTO getAllAboutBook(String bookName) {
        Book book = bookService.getBookByName(bookName);
        BookDTO responseDTO = new BookDTO()
                .setName(book.getName())
                .setPrice(book.getPrice())
                .setAuthorList(book.getAuthorList().stream().map(Author::getName).collect(Collectors.toList()));
        return responseDTO;
    }

    public Integer getTotalBookCostByAuthor(String author) {
        return authorService.totalCostBooksOf(author);
    }

    public List<Author> getRichAuthors() {return authorService.getSomeAuthors();}

    public List<Author> getIgors() {return authorService.getIgors();}


}
