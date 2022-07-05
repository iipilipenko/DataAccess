package com.pilipenko.homework.repository;

import com.pilipenko.homework.model.Author;
import com.pilipenko.homework.model.Author_;
import com.pilipenko.homework.model.Book;
import com.pilipenko.homework.model.Book_;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class AuthorRepositoryImpl implements AuthorRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Author> nameAuthorsHasMin3BooksCostGreaterThan2000() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Author> cq = cb.createQuery(Author.class);
        Root<Author> author = cq.from(Author.class);


        ListJoin<Author,Book> books = author.join(Author_.books);
        cq.select(author)
                .where(cb.greaterThanOrEqualTo(books.get(Book_.PRICE),2000))
                .groupBy(author.get(Author_.NAME))
                .having(cb.greaterThanOrEqualTo(cb.count(books.get(Book_.NAME)), 3L));

        TypedQuery<Author> query = entityManager.createQuery(cq);
        return query.getResultList();
    }


}
