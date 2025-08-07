package com.snafacturplus.snafacturplus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {    
    
    @GetMapping
    public String listarRoles(Model model) {
        return "layout";
    }

    @GetMapping("/")
    public String mostrarlayout() {
        return "layout";
    }

    @GetMapping("/plantilla")
    public String mostrarplantilla() {
        return "plantilla";
    }
    

}
