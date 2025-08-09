package com.snafacturplus.snafacturplus.controller;

import com.snafacturplus.snafacturplus.model.Login;
import com.snafacturplus.snafacturplus.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")

public class LoginController {
    @Autowired
    private UsuarioService usuarioService;

    
    @GetMapping
    public String listar(Model model) {
        return "seguridad-login";
    }
    
    @GetMapping("/")
    public String mostrarPaginaInicio(Model model) {
        model.addAttribute("login", new Login());
        return "seguridad-login";
    }
      
//    @PostMapping
//    public String ValidarUsuario(Login login) {
//        boolean res=false;
//        res=usuarioService.validarUsuario(login.Email, login.Password);
//        if (res==true){
//                return "redirect:/";
//        }
//        else{
//                return "redirect:/login";        
//        }
//    }

}
