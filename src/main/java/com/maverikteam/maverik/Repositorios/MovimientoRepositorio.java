package com.maverikteam.maverik.Repositorios;

import com.maverikteam.maverik.model.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepositorio extends JpaRepository<MovimientoDinero, Integer> {
}
