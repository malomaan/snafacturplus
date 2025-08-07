package com.snafacturplus.snafacturplus.repository;

import com.snafacturplus.snafacturplus.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
    
}
