package com.snafacturplus.snafacturplus.repository;

import com.snafacturplus.snafacturplus.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
