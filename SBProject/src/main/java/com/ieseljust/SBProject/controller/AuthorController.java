package com.ieseljust.SBProject.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ieseljust.SBProject.dto.AuthorDTO;
import com.ieseljust.SBProject.model.Author;
import com.ieseljust.SBProject.repository.AuthorRepository;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping
    public void createAuthor(@RequestBody AuthorDTO authorDTO) {
        Author author = AuthorDTO.convertToEntity(authorDTO);
        authorRepository.save(author);
    }

    @GetMapping("/authors")
    public List<AuthorDTO> getAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .map(AuthorDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AuthorDTO getAuthor(@PathVariable Integer id) {
        Optional<Author> author = authorRepository.findById(id);
        return author.map(AuthorDTO::convertToDTO).orElse(null);
    }

    @PutMapping("/{id}")
    public void updateAuthor(@PathVariable Integer id, @RequestBody AuthorDTO authorDTO) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent()) {
            Author updatedAuthor = AuthorDTO.convertToEntity(authorDTO);
            updatedAuthor.setId(id); // Ensure the ID is preserved
            authorRepository.save(updatedAuthor);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Integer id) {
        authorRepository.deleteById(id);
    }
}
