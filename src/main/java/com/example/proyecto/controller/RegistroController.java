package com.example.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.proyecto.model.User;
import com.example.proyecto.service.UserDetailsServiceImpl;



@Controller
public class RegistroController {

    @Autowired
    UserDetailsServiceImpl service;
    
    @GetMapping("/registro")
    public String registro(){
        return "registro";
    }
    @PostMapping("/registro")
    public String postMethodName(@ModelAttribute User usuario, Model model) {
        //TODO: process POST request
        usuario.setRole("USER");
        service.registroUsuario(usuario);
        model.addAttribute("successMessage", "Usuario registrado con éxito!");

        return "registro";
    }
    
}