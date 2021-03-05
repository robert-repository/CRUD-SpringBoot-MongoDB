package com.springbootspringdatamongo.demo.controller;

import com.springbootspringdatamongo.demo.model.Book;
import com.springbootspringdatamongo.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookRepository repository;

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book){
        repository.save(book);
        return "book added id: "+book.getBookName();
    }
    @PutMapping("/updateBook")
    public Book updateBook(@RequestBody Book book){
        Book existingBook = repository.findById(book.getId()).orElse(null);
        existingBook.setBookName(book.getBookName());
        existingBook.setBookAuthor(book.getBookAuthor());
        return repository.save(existingBook);
    }
    @GetMapping("/findAllBooks")
    public List<Book> getBooks(){
        return repository.findAll();
    }
    @GetMapping("/findBookById/{id}")
    public Optional<Book> getBook(@PathVariable int id){
        return repository.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
        repository.deleteById(id);
        return "book deleted"+id;
    }
}
