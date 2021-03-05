package com.springbootspringdatamongo.demo.repository;

import com.springbootspringdatamongo.demo.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Integer> {
}
