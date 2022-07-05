package com.pilipenko.homework.controller;

import com.pilipenko.homework.DTO.AuthorDTO;
import com.pilipenko.homework.DTO.BookDTO;
import com.pilipenko.homework.model.Author;
import com.pilipenko.homework.model.Book;
import com.pilipenko.homework.service.BookShopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookShopController {

    @Autowired
    private BookShopService bookShopService;

    @Operation(summary = "Find all authors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sending list of authors",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content)})
    @GetMapping(value = "/get/authors", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getAuthors() {
        final List<String> authors = bookShopService.getAllAuthors();

        return authors != null
                ? new ResponseEntity<>(authors, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @Operation(summary = "JPQUERY")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sending Igors",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content)})
    @GetMapping(value = "/get/igors", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Author>> getIgors() {
        final List<Author> authors = bookShopService.getIgors();

        return authors != null
                ? new ResponseEntity<>(authors, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @Operation(summary = "Find all books")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sending list of books",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content)})
    @GetMapping(value = "/get/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getBooks() {
        final List<String> books = bookShopService.getAllBooks();

        return books != null
                ? new ResponseEntity<>(books, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @Operation(summary = "Find all books by author name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sending list of books",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content)})
    @GetMapping(value = "/get/allBooks/{author}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getAllBooksFromAuthor(@PathVariable String author) {
        final List<String> books = bookShopService.getAllBooksFromAuthor(author);

        return books != null
                ? new ResponseEntity<>(books, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @Operation(summary = "Find all about book with input name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sending info",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content)})
    @GetMapping(value = "/get/allAboutBook/{bookName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDTO> getAllAboutBook(@PathVariable String bookName) {
        final BookDTO book = bookShopService.getAllAboutBook(bookName);

        return book != null
                ? new ResponseEntity<>(book, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @Operation(summary = "Find total cost all books by author")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sending total cost",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content)})
    @GetMapping(value = "/get/totalCostBooksOf/{authorName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> totalCostBooksOf(@PathVariable String authorName) {
        final Integer cost = bookShopService.getTotalBookCostByAuthor(authorName);

        return cost != null
                ? new ResponseEntity<>(cost, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @Operation(summary = "Find authors with min 3 book cost 2000")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sending list",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content)})
    @GetMapping(value = "/get/richAuthors", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Author>> totalCostBooksOf() {
        final List<Author> authors = bookShopService.getRichAuthors();

        return authors != null
                ? new ResponseEntity<>(authors, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

}
