package com.snafacturplus.snafacturplus.service;

import com.snafacturplus.snafacturplus.model.Empleado;
import com.snafacturplus.snafacturplus.repository.EmpleadoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;
    
    public List<Empleado> listarTodas() {
        return empleadoRepository.findAll();
    }
    public Empleado guardar(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
    public Empleado obtenerPorId(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }
    public void eliminar(Long id) {
        empleadoRepository.deleteById(id);
    }            
}
