package com.maverikteam.maverik.Servicios;


import com.maverikteam.maverik.model.Empleado;
import com.maverikteam.maverik.model.Empresa;

import java.util.List;
import java.util.Optional;

public interface IEmpresa {
    Empresa readById(Integer id) throws Exception;



    Empresa create (Empresa empresa) throws Exception;
    Empresa  update(Empresa empresa) throws Exception;
    List<Empresa> readAll() throws Exception;

    void delete(Integer id) throws Exception;
}
