package com.snafacturplus.snafacturplus.repository;
import com.snafacturplus.snafacturplus.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
