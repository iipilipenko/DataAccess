package com.pilipenko.homework.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Accessors(chain = true)
@Data
@NoArgsConstructor
public class Author {
    @Id
    private String name;

    @ManyToMany
    private List<Book> books;

}