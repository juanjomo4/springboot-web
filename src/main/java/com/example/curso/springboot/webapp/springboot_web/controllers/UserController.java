package com.example.curso.springboot.webapp.springboot_web.controllers;

// import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.curso.springboot.webapp.springboot_web.models.User;

@Controller
public class UserController {

    //Pasar parámetros a la vista
    @GetMapping("/details")
    public String details(Model model) {
        User user = new User("Jose", "Moral");
        // public String details(Map<String,Object> model) {
        model.addAttribute("title", "Hola mundo Spring Boot");
        // model.put("title","Hola mundo Spring Boot");
        model.addAttribute("User", user);
        return "details";
    }

    // Pasar parámetros a la vista con GetMapping
    // GetMapping es un atajo para RequestMapping con el método GET
    // RequestMapping es la forma más genérica de definir un controlador
    @GetMapping("/list")
    public String list(ModelMap model) {
        // List<User> users = new ArrayList<>();
        // users.add(new User("Pepe", "Quijano"));
        // users.add(new User("Antonio", "Torres", "prueba@test.com"));
        // users.add(new User("Juan", "Rodriguez"));
        // users.add(new User("Pedro", "Espinosa", "test@prueba.com"));
        // model.addAttribute("users", users);
        model.addAttribute("title", "Listado de usuarios");
        return "list";
    }

    // ModelAttribute se ejecuta antes de cada método del controlador para cargar datos
    // en el modelo, en este caso una lista de usuarios
    @ModelAttribute("users")
    public List<User> usersModel() {
        List<User> users = Arrays.asList(new User("Pepe", "Quijano"),
                new User("Antonio", "Torres", "prueba@test.com"),
                new User("Juan", "Rodriguez"),
                new User("Pedro", "Espinosa", "test@prueba.com"));
        return users;
    }

}
