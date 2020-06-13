package br.com.codenation.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/error")
public class ErroController {

    @GetMapping
    public String test(){
        return "Error Works!";
    }
}
