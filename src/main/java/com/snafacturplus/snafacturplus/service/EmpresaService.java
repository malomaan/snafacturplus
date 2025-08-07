package com.snafacturplus.snafacturplus.service;

import com.snafacturplus.snafacturplus.model.Empresa;
import com.snafacturplus.snafacturplus.repository.EmpresaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    
    @Autowired
    private EmpresaRepository empresaRepository;
    
    public List<Empresa> listarTodas() {
        return empresaRepository.findAll();
    }

    public Empresa guardar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Empresa obtenerPorId(Long id) {
        return empresaRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        empresaRepository.deleteById(id);
    }        
}
