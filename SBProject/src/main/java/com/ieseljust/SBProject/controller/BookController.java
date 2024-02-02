package com.ieseljust.SBProject.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ieseljust.SBProject.dto.BookDTO;
import com.ieseljust.SBProject.model.Book;
import com.ieseljust.SBProject.repository.BookRepository;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    public void createBook(@RequestBody BookDTO bookDTO) {
        Book book = BookDTO.convertToEntity(bookDTO);
        bookRepository.save(book);
    }

    @GetMapping("/books")
    public List<BookDTO> getBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                     .map(BookDTO::convertToDTO)
                     .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BookDTO getBook(@PathVariable Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map(BookDTO::convertToDTO).orElse(null);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable Integer id, @RequestBody BookDTO bookDTO) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            Book updatedBook = BookDTO.convertToEntity(bookDTO);
            updatedBook.setId(id); // Ensure the ID is preserved
            bookRepository.save(updatedBook);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookRepository.deleteById(id);
    }
}
