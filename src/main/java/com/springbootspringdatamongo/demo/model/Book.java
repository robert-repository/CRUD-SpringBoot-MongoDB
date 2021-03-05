package com.springbootspringdatamongo.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Book")
public class Book {
    @Id
    private int id;
    private String bookName;
    private String bookAuthor;
}
