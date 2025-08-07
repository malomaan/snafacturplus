package com.snafacturplus.snafacturplus.repository;

import com.snafacturplus.snafacturplus.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Marco Antonio Martinez Lopez
 * Interface de tipo repositorio que interactua entre
 * el modelo y la base de datos
 */
public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{
    
}
