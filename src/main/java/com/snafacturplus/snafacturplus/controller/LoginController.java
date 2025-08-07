package com.snafacturplus.snafacturplus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")


public class LoginController {

    @GetMapping
    public String listar(Model model) {
        return "seguridad-login";
    }
    
    @GetMapping("/")
    public String mostrarPaginaInicio() {
        return "seguridad-login";
    }
}
