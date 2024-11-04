package com.example.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @GetMapping("/blog")//Redirige aqui .defaultSuccessUrl("/") en securityconfig
    public String home(){
        return "blog";
    }
}