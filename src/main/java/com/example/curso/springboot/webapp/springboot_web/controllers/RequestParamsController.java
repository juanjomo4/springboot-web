package com.example.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.example.curso.springboot.webapp.springboot_web.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/params")
public class RequestParamsController {

    // Este método recibe un parámetro de tipo String llamado "message" a través de la URL.
    // El parámetro "message" es opcional, lo que significa que no es necesario incluirlo en la URL.
    // Por ejemplo, si la URL es /api/params/foo?message=Hello, el valor de "message" será "Hello".
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false) String message) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

    // Este método recibe dos parámetros: "text" y "code".
    // El parámetro "text" y "code" son obligatorios y se espera que siempre estén presentes en la URL.
    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam() String text, @RequestParam() Integer code) {
        ParamMixDto paramMixDto = new ParamMixDto();
        paramMixDto.setMessage(text);
        paramMixDto.setCode(code);
        return paramMixDto;
    }

    // Este método recibe los parámetros "text" y "code" a través de un objeto HttpServletRequest.
    // Los parámetros se obtienen directamente del objeto request,
    // lo que permite acceder a ellos de manera más flexible.
    @GetMapping("request")
    public ParamMixDto bar(HttpServletRequest request) {
        Integer code;
        try {
            code = Integer.valueOf(request.getParameter("code"));
        } catch (NumberFormatException e) {
            // Manejo de excepción si el parámetro "code" no es un número válido
            code = 0; // Valor por defecto en caso de error
        }
        ParamMixDto params = new ParamMixDto();
        params.setCode(code);
        params.setMessage(request.getParameter("text"));
        return params;
    }

}
