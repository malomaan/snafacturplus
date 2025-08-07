package com.snafacturplus.snafacturplus.controller;

import com.snafacturplus.snafacturplus.model.Proveedor;
import com.snafacturplus.snafacturplus.service.EmpresaService;
import com.snafacturplus.snafacturplus.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Marco Antonio Martinez Lopez
 * Controlador de la capa MVC que permite la interface entre 
 * la vista y los modelos de la entidad Proveedor
 */

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {
    
    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private EmpresaService empresaService;
    
    
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("proveedores", proveedorService.listarTodas());
        return "proveedor-list";
    }
    
    @GetMapping("/")
    public String mostrarPaginaInicio() {
        return "proveedor-Index";
    }
    
    
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        
        model.addAttribute("empresas", empresaService.listarTodas());        
        model.addAttribute("proveedor", new Proveedor());
        return "proveedor-form";
    }

    @PostMapping
    public String guardar(Proveedor proveedor) {
        proveedorService.guardar(proveedor);
        return "redirect:/proveedores";
    }

    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        
        model.addAttribute("empresas", empresaService.listarTodas());        
        model.addAttribute("proveedor", proveedorService.obtenerPorId(id));
        return "proveedor-form";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        proveedorService.eliminar(id);
        return "redirect:/proveedores";
    }   
    
    
    
    
    
}
