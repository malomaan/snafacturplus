package com.snafacturplus.snafacturplus.repository;
import com.snafacturplus.snafacturplus.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;        
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
        
@EnableJpaRepositories(basePackages = "com.snafacturplus.snafacturplus.repository")
@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{
    
//    @Query("SELECT u FROM Usuario u WHERE u.Email = :Email AND u.Password = :Password")
//    Optional<Usuario> validarUsuario(@Param("Email") String Email, @Param("Password") String Password);
    
    public Usuario findByEmailAndPassword(String email,String password);
    
}

