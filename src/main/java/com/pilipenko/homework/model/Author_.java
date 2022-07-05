//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.pilipenko.homework.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Author.class)
public abstract class Author_ {
    public static volatile ListAttribute<Author, Book> books;
    public static volatile SingularAttribute<Author, String> name;
    public static final String BOOKS = "books";
    public static final String NAME = "name";

    public Author_() {
    }
}
