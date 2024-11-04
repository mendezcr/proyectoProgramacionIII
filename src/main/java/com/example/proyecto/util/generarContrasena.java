package com.example.proyecto.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class generarContrasena {

    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        String hashedPassword = passwordEncoder.encode("perro");
        System.out.println("Contrasena encriptada: " + hashedPassword);
    }
}