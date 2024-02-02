package com.ieseljust.SBProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ieseljust.SBProject.dto.AuthorDTO;

@Service
public interface AuthorService {

    void saveAuthor(AuthorDTO AuthorDTO);
    AuthorDTO getAuthorById(Integer id);
    List<AuthorDTO> listAllAuthors();
    void deleteAuthor(Integer id);
    void updateAuthor(Integer id, AuthorDTO authorDTO);

}
