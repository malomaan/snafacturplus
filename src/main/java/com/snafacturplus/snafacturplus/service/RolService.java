package com.snafacturplus.snafacturplus.service;
import com.snafacturplus.snafacturplus.model.Rol;
import com.snafacturplus.snafacturplus.repository.RolRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {
        @Autowired
    private RolRepository rolRepository;

    public List<Rol> listarTodas() {
        return rolRepository.findAll();
    }

    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol obtenerPorId(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        rolRepository.deleteById(id);
    }

}
