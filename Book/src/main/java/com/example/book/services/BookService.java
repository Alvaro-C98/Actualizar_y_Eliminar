package com.example.book.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.models.Book;
import com.example.book.repositories.BookRepository;

@Service
public class BookService {
	
	//Agregando el book al repositorio como una dependencia
	@Autowired
	private BookRepository bookRepository;

	//Devolviendo todos los libros.
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	//Creando un libro.
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	//Obteniendo la información de un libro
	public Book findBook(Long id) {	
		Optional<Book> optionalBook = bookRepository.findById(id);
	    if(optionalBook.isPresent()) {
	    	return optionalBook.get();
	    }else {
	        return null;
	    }
	 }
	
    //Actualizar un libro
    public Book update(long id, String title, String desc, String lang, int pages) {
    	Book temp = findBook(id);
    	temp.setDescription(desc);
    	temp.setTitle(title);
    	temp.setNumberOfPages(pages);
    	temp.setLanguage(lang);
    	return bookRepository.save(temp);
    }
    
    //Borrar un libro
    public void delete(long id) {
    	bookRepository.deleteById(id);
    }
}
