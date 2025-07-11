package com.example.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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

    // Atributos de la clase PathVariableController desde application.properties
    @Value("${config.code}")
    private Integer code;
    @Value("${config.username}")
    private String username;
    @Value("${config.password}")
    private String password;
    @Value("${config.message}")
    private String message;
    @Value("${config.listOfStrings}")
    private List<String> listOfStrings;
    // Este atributo se utiliza para almacenar una lista de cadenas de texto (strings)
    // que se configuran en application.properties.
    // La anotación @Value permite inyectar el valor de la propiedad en la lista.
    // De esta forma se separan los valores por comas dentro de la lista de forma manual.
    @Value("#{'${config.listOfStrings}'.toUpperCase().split(',')}")
    private List<String> listOfStringsWithSplit;
    // Este atributo se utiliza para almacenar un mapa de valores clave-valor
    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;
    @Value("#{${config.valuesMap}.product}")
    private String product;

    // Inyección de dependencias para acceder a las propiedades del entorno de Spring
    // Esto permite acceder a las propiedades configuradas en application.properties
    @Autowired
    private Environment environment;

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

    @GetMapping("/values")
    public Map<String, Object> values() {
        // Este método devuelve un mapa con los valores de las propiedades configuradas en application.properties.
        Map<String, Object> json = new HashMap<>();
        json.put("code", environment.getProperty("config.code"));
        json.put("username", username);
        json.put("password", password);
        json.put("message", message);
        // De esta forma se obtiene el valor de la propiedad "config.message" del archivo application.properties
        json.put("message2", environment.getProperty("config.message"));
        json.put("code2", code);
        json.put("listOfStrings", listOfStrings);
        json.put("listOfStringsWithSplit", listOfStringsWithSplit);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        return json;
    }
}
