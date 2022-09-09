package com.maverikteam.maverik.Repositorios;

import com.maverikteam.maverik.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepositorio extends JpaRepository<Empresa, Integer> {
}
