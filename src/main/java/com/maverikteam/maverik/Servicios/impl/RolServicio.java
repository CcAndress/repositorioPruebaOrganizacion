package com.maverikteam.maverik.Servicios.impl;


import com.maverikteam.maverik.Repositorios.RolRepositorio;
import com.maverikteam.maverik.Servicios.IRol;
import com.maverikteam.maverik.model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RolServicio implements IRol {

    @Autowired
    private RolRepositorio RolRep;

    public List<Rol> getRol() {
        return this.RolRep.findAll();

    }

    @Override
    public Rol readById(Integer id) throws Exception {
        return RolRep.findById(id).orElse(null);
    }

    @Override
    public Rol create(Rol rol) throws Exception {
        return this.RolRep.save(rol);
    }

    @Override
    public Rol update(Rol rol) throws Exception {
        return this.RolRep.save(rol);
    }

    @Override
    public List<Rol> readAll() throws Exception {
        return null;
    }

    @Override
    public void delete(Integer id) throws Exception {
        RolRep.deleteById(id);
    }
}
