package com.pilipenko.homework.repository;

import com.pilipenko.homework.model.Author;
import com.pilipenko.homework.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long>, AuthorRepositoryCustom {
    Author getAuthorByName (String name);

    @Query(
            value = "SELECT * FROM author a WHERE a.name = 'igor'",
            nativeQuery = true)
    List<Author> getAuthorIgorNative ();
}
