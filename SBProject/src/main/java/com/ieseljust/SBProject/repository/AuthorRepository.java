package com.ieseljust.SBProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ieseljust.SBProject.model.Author;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    
}
