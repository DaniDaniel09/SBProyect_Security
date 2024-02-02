package com.ieseljust.SBProject.dto;

import java.util.Set;

import com.ieseljust.SBProject.model.Annotations.*;

public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    
    @NotBlank
    @Size(max = 50, min = 0)
    @Email
    private String email;
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}