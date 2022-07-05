package com.pilipenko.homework.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Entity
@Accessors(chain = true)
@Data
@NoArgsConstructor
public class Book {

    @Id
    private String name;

    private Integer price;

    @JsonIgnore
    @ManyToMany(mappedBy = "books")
    private List<Author> authorList;

}
