package com.maverikteam.maverik.Servicios;

import com.maverikteam.maverik.model.Empresa;
import com.maverikteam.maverik.model.MovimientoDinero;

import java.util.List;

public interface IMovimiento {
    MovimientoDinero findById(Integer id) throws Exception;

    MovimientoDinero create (MovimientoDinero mov) throws Exception;
    MovimientoDinero  update(MovimientoDinero mov) throws Exception;
    List<MovimientoDinero> readAll() throws Exception;

    void deleteMov(Integer id) throws Exception;
}
