package com.example.proyecto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyecto.model.User;

//mport com.example.login_db.model.User; 

public interface userRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

//el repositirio comunica el modelo con la base de datos, sirve para hablar con una entidad en este caso modelo