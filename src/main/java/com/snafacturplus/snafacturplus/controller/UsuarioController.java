package com.snafacturplus.snafacturplus.controller;
import com.snafacturplus.snafacturplus.model.Rol;
import com.snafacturplus.snafacturplus.model.Usuario;
import com.snafacturplus.snafacturplus.repository.RolRepository;
import com.snafacturplus.snafacturplus.service.RolService;
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
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private RolService rolService;
    
  
    
    
    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarTodas());
        return "usuario-list";
    }
    
    @GetMapping("/")
    public String mostrarPaginaInicio() {
        return "usuario-Index";
    }

    
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoUsuario(Model model) {
        model.addAttribute("roles", rolService.listarTodas());
        model.addAttribute("usuario", new Usuario());
        return "usuario-form";
    }

    @PostMapping
    public String guardarUsuario(Usuario usuario) {
        usuarioService.guardar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarUsuario(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", usuarioService.obtenerPorId(id));
        model.addAttribute("roles", rolService.listarTodas());
        return "usuario-form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return "redirect:/usuarios";
    }
    
}
