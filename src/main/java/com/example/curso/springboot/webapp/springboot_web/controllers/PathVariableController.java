package com.example.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso.springboot.webapp.springboot_web.models.User;
import com.example.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    // Este método recibe un parámetro de tipo String llamado "message" a través de la URL.
    // El parámetro "message" es obligatorio, lo que significa que debe incluirse en la URL.
    @GetMapping("/baz{message}")
    public ParamDto baz(@PathVariable String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    // Este método recibe un parámetro de tipo String llamado "product" y un parámetro de tipo Long llamado "id" a través de la URL.
    // Ambos parámetros son obligatorios, lo que significa que deben incluirse en la URL.
    @GetMapping("/mix/{product}/{id}")
    // Ejemplo de URL: /api/var/mix/phone/123
    public Map<String, Object> mixMapVar(@PathVariable String product, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        // Este método recibe un objeto User en el cuerpo de la solicitud (request body).
        // El objeto User debe contener los campos name, lastname y email.
        // Si alguno de estos campos no se proporciona, se devolverá un error de validación.
        ///Guardar el usuario en la base de datos
        user.setName(user.getName());
        user.setLastname(user.getLastname());
        user.setEmail(user.getEmail());
        return user;
    }

}
