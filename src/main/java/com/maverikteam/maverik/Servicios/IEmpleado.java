package com.maverikteam.maverik.Servicios;

import com.maverikteam.maverik.model.Empleado;

import java.util.List;
import java.util.Optional;

public interface IEmpleado {

    Empleado create (Empleado empleado) throws Exception;

    Empleado update(Empleado empleado) throws Exception;
    List<Empleado> readAll() throws Exception;

    Empleado readById(Integer id) throws Exception;

    void delete(Integer id) throws Exception;


}
