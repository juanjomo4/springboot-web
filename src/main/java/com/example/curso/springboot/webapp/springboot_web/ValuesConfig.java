package com.example.curso.springboot.webapp.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

// La configuración de la clase ValuesConfig permite cargar un archivo de propiedades
// llamado values.properties que contiene valores clave-valor que pueden ser utilizados
// en la aplicación Spring Boot. El archivo se carga con codificación UTF-8.
@Configuration
@PropertySources({
    @PropertySource(value = "classpath:values.properties", encoding="UTF-8")
})
public class ValuesConfig {

}
