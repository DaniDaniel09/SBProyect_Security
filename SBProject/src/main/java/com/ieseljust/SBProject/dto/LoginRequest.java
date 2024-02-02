package com.ieseljust.SBProject.dto;

import com.ieseljust.SBProject.model.Annotations.NotBlank;

public class LoginRequest {
    @NotBlank
    private String username;
    
    @NotBlank
    private String password;
}