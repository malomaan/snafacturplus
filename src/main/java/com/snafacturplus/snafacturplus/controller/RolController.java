package com.snafacturplus.snafacturplus.controller;

import com.snafacturplus.snafacturplus.model.Rol;
import com.snafacturplus.snafacturplus.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public String listarRoles(Model model) {
        model.addAttribute("roles", rolService.listarTodas());
        return "rol-list";
    }
    
    @GetMapping("/")
    public String mostrarPaginaInicio() {
        return "index";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoRol(Model model) {
        model.addAttribute("rol", new Rol());
        return "rol-form";
    }

    @PostMapping
    public String guardarPersona(Rol rol) {
        rolService.guardar(rol);
        return "redirect:/roles";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarRol(@PathVariable Long id, Model model) {
        model.addAttribute("rol", rolService.obtenerPorId(id));
        return "rol-form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarRol(@PathVariable Long id) {
        rolService.eliminar(id);
        return "redirect:/roles";
    }
    
}
