package com.maverikteam.maverik.Servicios.impl;


import com.maverikteam.maverik.Repositorios.MovimientoRepositorio;
import com.maverikteam.maverik.Servicios.IMovimiento;
import com.maverikteam.maverik.model.MovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoServicio implements IMovimiento {
    @Autowired
    private MovimientoRepositorio remov;

    public List<MovimientoDinero> getMovimientoDinero(){
        return this.remov.findAll();
    }

    @Override
    public MovimientoDinero findById(Integer id) throws Exception {
        return this.remov.findById(id).orElse(null);
    }

    @Override
    public MovimientoDinero create(MovimientoDinero mov) throws Exception {
        return this.remov.save(mov);
    }

    @Override
    public MovimientoDinero update(MovimientoDinero mov) throws Exception {
        return this.remov.save(mov);
    }

    @Override
    public List<MovimientoDinero> readAll() throws Exception {
        return this.remov.findAll();
    }

    @Override
    public void deleteMov(Integer id) throws Exception {
        remov.deleteById(id);
    }
}
