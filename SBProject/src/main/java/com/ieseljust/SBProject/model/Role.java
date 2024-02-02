package com.ieseljust.SBProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Role {
    private Integer id;
    private ERole name;
}
