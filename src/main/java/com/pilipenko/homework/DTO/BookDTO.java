package com.pilipenko.homework.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pilipenko.homework.model.Author;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class BookDTO {

    private String name;

    private Integer price;

    @JsonIgnore
    private List<String> authorList;

}
