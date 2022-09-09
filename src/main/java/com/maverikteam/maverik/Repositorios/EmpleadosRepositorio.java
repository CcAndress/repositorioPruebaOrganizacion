package com.maverikteam.maverik.Repositorios;

import com.maverikteam.maverik.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadosRepositorio extends JpaRepository<Empleado, Integer> {
}
