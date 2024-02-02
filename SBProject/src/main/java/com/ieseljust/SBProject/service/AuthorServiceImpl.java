package com.ieseljust.SBProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ieseljust.SBProject.dto.AuthorDTO;
import com.ieseljust.SBProject.model.Author;
import com.ieseljust.SBProject.repository.AuthorRepository;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void saveAuthor(AuthorDTO AuthorDTO) {
        Author author = com.ieseljust.SBProject.dto.AuthorDTO.convertToEntity(AuthorDTO);
        authorRepository.save(author);
    }

    @Override
    public AuthorDTO getAuthorById(Integer id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent()) {
            return AuthorDTO.convertToDTO(author.get());
        } else {
            return null;
        }
    }

    @Override
    public List<AuthorDTO> listAllAuthors() {
        List<Author> lista = authorRepository.findAll();
        List<AuthorDTO> listaResultado = new ArrayList<AuthorDTO>();
        for (int i = 0; i < lista.size(); ++i) {
            listaResultado.add(AuthorDTO.convertToDTO(lista.get(i)));
        }
        return listaResultado;
    }

    @Override
    public void deleteAuthor(Integer id) {
        authorRepository.deleteById(id);
    }

    @Override
    public void updateAuthor(Integer id, AuthorDTO authorDTO) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()) {
            Author author = optionalAuthor.get();
            author.setName(authorDTO.getName());
            author.setBirthYear(authorDTO.getBirthYear());
            authorRepository.save(author);
        }
    }

}
