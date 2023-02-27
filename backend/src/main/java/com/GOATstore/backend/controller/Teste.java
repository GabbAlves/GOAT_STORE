package com.GOATstore.backend.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Teste {
    

    @GetMapping("/")
    public String heloo(){
        return "Ola mundo Spring" + new java.util.Date();
    }
}
