package com.ieseljust.SBProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ieseljust.SBProject.dto.BookDTO;
import com.ieseljust.SBProject.model.Book;
import com.ieseljust.SBProject.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository BookRepository;

    @Override
    public void saveBook(BookDTO BookDTO) {
        Book Book = com.ieseljust.SBProject.dto.BookDTO.convertToEntity(BookDTO);
        BookRepository.save(Book);
    }

    @Override
    public BookDTO getBookById(Integer id) {
        Optional<Book> Book = BookRepository.findById(id);
        if (Book.isPresent()) {
            return BookDTO.convertToDTO(Book.get());
        } else {
            return null;
        }
    }

    @Override
    public List<BookDTO> listAllBooks() {
        List<Book> lista = BookRepository.findAll();
        List<BookDTO> listaResultado = new ArrayList<BookDTO>();
        for (int i = 0; i < lista.size(); ++i) {
            listaResultado.add(BookDTO.convertToDTO(lista.get(i)));
        }
        return listaResultado;
    }

    @Override
    public void deleteBook(Integer id) {
        BookRepository.deleteById(id);
    }

    @Override
    public void updateBook(Integer id, BookDTO bookDTO) {
        Optional<Book> optionalBook = BookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(bookDTO.getTitle());
            book.setPublicationYear(bookDTO.getPublicationYear());
            BookRepository.save(book);
        }
    }

}
