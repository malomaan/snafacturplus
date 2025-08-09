package com.snafacturplus.snafacturplus.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {    
     
    @GetMapping
    public String listarRoles(Model model,HttpSession session) {
        String Usuario = (String) session.getAttribute("Usuario");        
        if (Usuario == null || Usuario.equals("")){
                        return "redirect:/login";
        }
        //session.setAttribute("Usuario", Usuario);
        model.addAttribute("Usuario", Usuario);
        return "Index";
    }

    @GetMapping("/")
    public String mostrarlayout() {
        return "index";
    }

    @GetMapping("/plantilla")
    public String mostrarplantilla() {
        return "plantilla";
    }
    

}
