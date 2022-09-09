package com.maverikteam.maverik.Servicios;

import com.maverikteam.maverik.model.MovimientoDinero;
import com.maverikteam.maverik.model.Rol;

import java.util.List;

public interface IRol {
    Rol readById(Integer id) throws Exception;

    Rol create (Rol rol) throws Exception;
    Rol  update(Rol rol) throws Exception;
    List<Rol> readAll() throws Exception;

    void delete(Integer id) throws Exception;
}
