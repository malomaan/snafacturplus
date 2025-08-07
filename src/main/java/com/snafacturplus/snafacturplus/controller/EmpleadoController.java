package com.snafacturplus.snafacturplus.controller;

import com.snafacturplus.snafacturplus.model.Empleado;
import com.snafacturplus.snafacturplus.model.Empresa;
import com.snafacturplus.snafacturplus.service.EmpleadoService;
import com.snafacturplus.snafacturplus.service.EmpresaService;
import com.snafacturplus.snafacturplus.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empleados")

public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;
    
    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private UsuarioService usuarioService;

    
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("empleados", empleadoService.listarTodas());
        return "empleado-list";
    }
    
    @GetMapping("/")
    public String mostrarPaginaInicio() {
        return "empleado-Index";
    }
    
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("empresas", empresaService.listarTodas());
        model.addAttribute("usuarios", usuarioService.listarTodas());
        
        model.addAttribute("empleado", new Empleado());
        return "empleado-form";
    }
    
    @PostMapping
    public String guardar(Empleado empleado) {
        empleadoService.guardar(empleado);
        return "redirect:/empleados";
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("empresas", empresaService.listarTodas());
        model.addAttribute("usuarios", usuarioService.listarTodas());

        model.addAttribute("empleado", empleadoService.obtenerPorId(id));
        return "empleado-form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        empleadoService.eliminar(id);
        return "redirect:/empleados";
    }   
}
