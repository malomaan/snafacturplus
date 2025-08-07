package com.snafacturplus.snafacturplus.service;

import com.snafacturplus.snafacturplus.model.Proveedor;
import com.snafacturplus.snafacturplus.repository.ProveedorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marco Antonio Martinez Lopez
 * Clase que permite conectar los servicios de la base de datos
 * de la tabla proveedor con la interface y el controlador
 */

@Service
public class ProveedorService {
    
    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> listarTodas() {
        return proveedorRepository.findAll();
    }

    public Proveedor guardar(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }
    
    public Proveedor obtenerPorId(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }
    
    public void eliminar(Long id) {
        proveedorRepository.deleteById(id);
    }        
    
}
