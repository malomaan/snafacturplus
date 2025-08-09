package com.snafacturplus.snafacturplus.service;

import com.snafacturplus.snafacturplus.model.Usuario;
import com.snafacturplus.snafacturplus.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository uruarioRepository;

    public List<Usuario> listarTodas() {
        return uruarioRepository.findAll();
    }

    public Usuario guardar(Usuario usuario) {
        return uruarioRepository.save(usuario);
    }

    public Usuario obtenerPorId(Long id) {
        return uruarioRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        uruarioRepository.deleteById(id);
    }

    public boolean validarUsuario(String email, String password) {
        boolean res = false;
        Usuario usuario = new Usuario();
        usuario = uruarioRepository.findByEmailAndPassword(email, password);
        if(usuario != null) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }

}
