package com.snafacturplus.snafacturplus.controller;

import com.snafacturplus.snafacturplus.model.Empresa;
import com.snafacturplus.snafacturplus.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empresas")

public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;
    
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("empresas", empresaService.listarTodas());
        return "empresa-list";
    }
    
    @GetMapping("/")
    public String mostrarPaginaInicio() {
        return "empresa-Index";
    }
    
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("empresa", new Empresa());
        return "empresa-form";
    }
    
    @PostMapping
    public String guardar(Empresa empresa) {
        empresaService.guardar(empresa);
        return "redirect:/empresas";
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("empresa", empresaService.obtenerPorId(id));
        return "empresa-form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        empresaService.eliminar(id);
        return "redirect:/empresas";
    }   
}
