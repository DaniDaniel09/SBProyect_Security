package com.ieseljust.SBProject.dto;

import java.io.Serializable;

import com.ieseljust.SBProject.model.*;

public class BookDTO implements Serializable{
    
    private int id;
    private String title;
    private int publicationYear;
    private Author author;

    public BookDTO(){}

    public BookDTO(int id, String title, int publicationYear, Author author){
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public static BookDTO convertToDTO(Book book){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setPublicationYear(book.getPublicationYear());
        bookDTO.setAuthor(book.getAuthor());
        return bookDTO;
    }

    public static Book convertToEntity(BookDTO bookDTO){
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setPublicationYear(bookDTO.getPublicationYear());
        book.setAuthor(bookDTO.getAuthor());
        return book;
    }

}
