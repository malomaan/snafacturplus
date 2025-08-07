package com.snafacturplus.snafacturplus.controller;

import com.snafacturplus.snafacturplus.model.Cliente;
import com.snafacturplus.snafacturplus.service.ClienteService;
import com.snafacturplus.snafacturplus.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private EmpresaService empresaService;   
       
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clientes", clienteService.listarTodas());
        return "cliente-list";
    }
    
    @GetMapping("/")
    public String mostrarPaginaInicio() {
        return "cliente-Index";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("empresas", empresaService.listarTodas());        
        model.addAttribute("cliente", new Cliente());
        return "cliente-form";
    }
    
    @PostMapping
    public String guardar(Cliente cliente) {
        clienteService.guardar(cliente);
        return "redirect:/clientes";
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("empresas", empresaService.listarTodas());
        model.addAttribute("cliente", clienteService.obtenerPorId(id));
        return "cliente-form";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        clienteService.eliminar(id);
        return "redirect:/clientes";
    }   
}
