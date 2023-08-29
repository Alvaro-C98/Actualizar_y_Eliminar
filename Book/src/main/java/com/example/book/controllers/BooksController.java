package com.example.book.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.book.models.Book;
import com.example.book.services.BookService;

import jakarta.validation.Valid;

@Controller
public class BooksController {
    
    
    @Autowired
    private BookService bookService;
    
    
    //Mostrar todos los libros
    @GetMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/books/index.jsp";
    }
    
    //Mostrar un libro en especifico
    @GetMapping("/books/{id}")
    public String show(@PathVariable("id") Long id,
    		Model model) {
    	Book book = bookService.findBook(id);
    	model.addAttribute("book",book);
    	return "/books/show.jsp";
    }
    
    //Mostrar un nuevo libro
    @GetMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/books/new.jsp";
    }
    
    //Crear un nuevo libro
    @PostMapping(value="/books")
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
    
    //Mostrar el libro a editar
    @GetMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "/books/edit.jsp";
    }
    
    //Editar un libro
    @PutMapping(value="/books/{id}")
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/edit.jsp";
        } else {
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }
    
    //ELiminar un libro
    @DeleteMapping(value="/books/{id}")
    public String destroy(@PathVariable("id") Long id) {
        bookService.delete(id);
        return "redirect:/books";
    }
    
}
