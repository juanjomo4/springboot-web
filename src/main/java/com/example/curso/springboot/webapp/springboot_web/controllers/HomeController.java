package com.example.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
     * Redirige a la lista de usuarios.
     *
     * @return Redirección a la ruta /list
     */
    @GetMapping({"", "/", "home"})
    public String home() {
        return "redirect:/list";
    }
    
    /**
     * Redirige utilizando forward a la lista de usuarios.
     * Esta es una alternativa a la redirección que mantiene la URL original.
     * De esta forma, no se pierde el contexto de la URL y se puede acceder a los recursos
     *
     * @return Redirección a la ruta /list
     */
    // @GetMapping({"", "/", "home"})
    // public String home() {
    //     return "forward:/list";
    // }



}
