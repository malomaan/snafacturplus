package com.snafacturplus.snafacturplus.controller;

import com.snafacturplus.snafacturplus.model.Login;
import com.snafacturplus.snafacturplus.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")

public class LoginController {
    @Autowired
    private UsuarioService usuarioService;

    
    @GetMapping
    public String listar(Model model,@ModelAttribute("mensaje") String mensaje) {
       model.addAttribute("login", new Login());
        model.addAttribute("mensaje",mensaje);
       return "seguridad-login";
    }
    
    @GetMapping("/")
    public String mostrarPaginaInicio(Model model,@ModelAttribute("mensaje") String mensaje) {
        model.addAttribute("login", new Login());
        model.addAttribute("mensaje","Hola Mundo");
        return "seguridad-login";
    }
      
    @PostMapping
    public String ValidarUsuario(Model model,Login login,HttpSession session) {
       boolean res=false;
       res=usuarioService.validarUsuario(login.Email, login.Password);
        if (res==true){
                session.setAttribute("Usuario", login.Email);
                return "redirect:/index";
        }
        else{
                model.addAttribute("mensaje", "Las credenciales de acceso son incorrecta");
                return "seguridad-login";
        }
    }

}
