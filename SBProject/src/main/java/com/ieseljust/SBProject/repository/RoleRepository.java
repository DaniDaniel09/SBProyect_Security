package com.ieseljust.SBProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ieseljust.SBProject.model.ERole;
import com.ieseljust.SBProject.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
Optional<Role> findByName(ERole name);
}


