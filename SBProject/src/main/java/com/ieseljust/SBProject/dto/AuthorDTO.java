package com.ieseljust.SBProject.dto;

import java.io.Serializable;

import com.ieseljust.SBProject.model.*;

public class AuthorDTO implements Serializable{
    
    private int id;
    private String name;
    private int birthYear;
    private Book book;

    public AuthorDTO(){}

    public AuthorDTO(int id, String name, int birthYear, Book book){
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.book = book;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Book getBook() {
        return book;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public static AuthorDTO convertToDTO(Author author){
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setName(author.getName());
        authorDTO.setBirthYear(author.getBirthYear());
        authorDTO.setBook(author.getBook());
        return authorDTO;
    }

    public static Author convertToEntity(AuthorDTO authorDTO){
        Author author = new Author();
        author.setId(authorDTO.getId());
        author.setName(authorDTO.getName());
        author.setBirthYear(authorDTO.getBirthYear());
        author.setBook(authorDTO.getBook());
        return author;
    }
}
