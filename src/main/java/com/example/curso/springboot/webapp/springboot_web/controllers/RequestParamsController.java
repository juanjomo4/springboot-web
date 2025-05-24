package com.example.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.example.curso.springboot.webapp.springboot_web.models.dto.ParamMixDto;

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

}
