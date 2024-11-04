package com.example.proyecto.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service; 

import com.example.proyecto.model.User;
import com.example.proyecto.repository.userRepository;
//import com.example.login_db.repository.userRepository; 


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
   
    @Autowired
    private userRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Datos de login erroneos!" + username));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
                Collections.singleton(() -> "ROLE_" + user.getRole()));
    }

    public void registroUsuario(User usuario){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        String hashedPassword = passwordEncoder.encode(usuario.getPassword());

        usuario.setPassword(hashedPassword);

        // validar si usuario esta duplicado

        userRepository.save(usuario);

    }
}