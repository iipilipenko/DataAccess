//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.pilipenko.homework.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Book.class)
public abstract class Book_ {
    public static volatile SingularAttribute<Book, Integer> price;
    public static volatile ListAttribute<Book, Author> authorList;
    public static volatile SingularAttribute<Book, String> name;
    public static final String PRICE = "price";
    public static final String AUTHOR_LIST = "authorList";
    public static final String NAME = "name";

    public Book_() {
    }
}
