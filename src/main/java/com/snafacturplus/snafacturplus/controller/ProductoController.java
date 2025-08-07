package com.snafacturplus.snafacturplus.controller;

import com.snafacturplus.snafacturplus.model.Producto;
import com.snafacturplus.snafacturplus.service.EmpresaService;
import com.snafacturplus.snafacturplus.service.ProductoService;
import com.snafacturplus.snafacturplus.service.ProveedorService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;        
    @Autowired
    private ProveedorService proveedorService;
    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", productoService.listarTodas());
        return "producto-list";
    }
    
    @GetMapping("/")
    public String mostrarPaginaInicio() {
        return "producto-Index";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("empresas", empresaService.listarTodas()); 
        model.addAttribute("proveedores", proveedorService.listarTodas());         
        Producto pro=new Producto();
 
        model.addAttribute("producto", new Producto());
        return "producto-form";
    }

    @PostMapping
    public String guardar(Producto producto) throws ParseException {
        /*SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        java.util.Date fechaUtil = formato.parse(producto.getFechaIngreso().toString());
        Date fechaSQL = new Date(fechaUtil.getTime());
                
        producto.setFechaIngreso(fechaSQL);*/
        productoService.guardar(producto);
        return "redirect:/productos";
    }

    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("empresas", empresaService.listarTodas()); 
        model.addAttribute("proveedores", proveedorService.listarTodas());                 
        model.addAttribute("producto", productoService.obtenerPorId(id));
        return "producto-form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return "redirect:/productos";
    }   
    

}
