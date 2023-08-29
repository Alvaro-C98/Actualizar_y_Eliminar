package com.example.book.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.models.Book;
import com.example.book.services.BookService;
@RestController
public class BooksApi {
    
    @Autowired
    private BookService bookService;
	
    //Mostrar todos los libros
    @GetMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }
    
    //Crear un libro
    @PostMapping(value="/api/books")
    public Book create(@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang, 
    		@RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    
    //Buscar un libro en especifico
    @GetMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }
    
    //Actualizar un libro en especifico
    @PutMapping("/api/books/{id}")
    public Book update(@PathVariable("id") long id,
    @RequestParam(value="title") String title, 
    @RequestParam(value="description") String desc, 
    @RequestParam(value="language") String lang,
    @RequestParam(value="pages") Integer numOfPages) {
    	Book book = new Book(title, desc, lang, numOfPages);
    	return bookService.update(book);
    }
    
    //Borrar un libro
    @DeleteMapping("/api/books/{id}")
    public void delete(@PathVariable("id") long id) {
    	bookService.delete(id);
    }
}