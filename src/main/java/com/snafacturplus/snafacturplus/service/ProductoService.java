package com.snafacturplus.snafacturplus.service;

import com.snafacturplus.snafacturplus.model.Producto;
import com.snafacturplus.snafacturplus.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProductoService {
 
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarTodas() {
        return productoRepository.findAll();
    }
    
    public Producto guardar(Producto empresa) {
        return productoRepository.save(empresa);
    }
    
    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }
    
    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }       

}
