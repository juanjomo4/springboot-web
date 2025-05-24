package com.example.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso.springboot.webapp.springboot_web.models.User;
import com.example.curso.springboot.webapp.springboot_web.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

    // Comentario de como funciona RestController usando una clase DTO
    // Devuelve un JSON
    @GetMapping("/details")
    public UserDto details() {
        UserDto userDto = new UserDto();
        User user = new User("Jose", "Moral");
        userDto.setUser(user);
        userDto.setTitle("Hola Mundo UserDto Rest Controller");
        return userDto;
    }

    @GetMapping("/list")
    public List<User> list() {
        User user1 = new User("Pedro", "Calderon");
        User user2 = new User("Juan", "Mata");
        user2.setEmail("prueba@test.com");
        User user3 = new User("Fernando", "Olmo");
        User user4 = new User("Enrique", "Sanchez");
        return List.of(user1, user2, user3, user4);
        // List<User> users = new ArrayList<>();
        // users.add(user1);
        // users.add(user2);
        // users.add(user3);
        // users.add(user4);
        // return users;
    }

    @GetMapping("/details-map")
    public Map<String, Object> detailsMap() {
        User user = new User("Jose", "Moral");
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo User Rest Controller");
        body.put("User", user);
        return body;
    }

}
