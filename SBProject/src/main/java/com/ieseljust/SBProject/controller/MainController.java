package com.ieseljust.SBProject.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {

    @Value("${app.name}")
    private String appName;

    @Value("${developer.name}")
    private String devName;

    @GetMapping("/")
    public String welcome() {
        String res = "Welcome to the start page of the Spring Boot project! "+"You are running "+appName+" made by "+devName;
        return res;
    }

    @GetMapping("/about")
    public String about() {
        return "Esta es la página 'Acerca de' de nuestra aplicación.";
    }
}

