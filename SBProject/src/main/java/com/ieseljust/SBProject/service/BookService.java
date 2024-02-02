package com.ieseljust.SBProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ieseljust.SBProject.dto.BookDTO;

@Service
public interface BookService {

    void saveBook(BookDTO BookDTO);
    BookDTO getBookById(Integer id);
    List<BookDTO> listAllBooks();
    void deleteBook(Integer id);
    void updateBook(Integer id, BookDTO bookDTO);

}
