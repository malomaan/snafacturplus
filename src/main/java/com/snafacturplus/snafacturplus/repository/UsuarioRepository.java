package com.snafacturplus.snafacturplus.repository;
import com.snafacturplus.snafacturplus.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{
    
}
