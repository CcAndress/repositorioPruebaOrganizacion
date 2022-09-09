package com.maverikteam.maverik.Servicios.impl;

import com.maverikteam.maverik.Repositorios.EmpleadosRepositorio;
import com.maverikteam.maverik.Repositorios.EmpresaRepositorio;
import com.maverikteam.maverik.Servicios.IEmpleado;
import com.maverikteam.maverik.exceptions.EmpleadoNotFoundException;
import com.maverikteam.maverik.exceptions.EmpresaNotFoundException;
import com.maverikteam.maverik.exceptions.ItemIsAlreadyAssigned;
import com.maverikteam.maverik.model.Empleado;
import com.maverikteam.maverik.model.Empresa;
import com.maverikteam.maverik.model.MovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;


@Service
public class EmpleadoServicio implements IEmpleado {
    private final EmpleadosRepositorio empl_repo;
    private final MovimientoServicio mov_serv;


    @Autowired
    public EmpleadoServicio(EmpleadosRepositorio empl_repo, MovimientoServicio mov_serv){

        this.empl_repo = empl_repo;
        this.mov_serv = mov_serv;
    }
    public List<Empleado> getEmpleados(){

        return this.empl_repo.findAll();
    }

    @Override
    public Empleado create(Empleado empleado) throws Exception {
        return this.empl_repo.save(empleado);
    }

    @Override
    public Empleado update(Empleado empleado) throws Exception {
        return this.empl_repo.save(empleado);
    }

    @Override
    public List<Empleado> readAll() throws Exception {
        return this.empl_repo.findAll();
    }

    @Override
    public Empleado readById(Integer id) throws Exception {
        return this.empl_repo.findById(id).orElseThrow(() ->
                new EmpleadoNotFoundException(id));
    }

    @Override
    public void delete(Integer id) throws Exception {
        empl_repo.deleteById(id);
    }

    @Transactional
    public Empleado addMovimiento(Integer empl_id, Integer mov_id) throws Exception {
        Empleado empleado = readById(empl_id);
        MovimientoDinero movimientoDinero = mov_serv.findById(mov_id);
        if(Objects.nonNull(empleado.getEmpresa())){
            throw new ItemIsAlreadyAssigned(mov_id, movimientoDinero.getEmpleado().getId());
        }
        empleado.addMovimiento(movimientoDinero);
        movimientoDinero.setEmpleado(empleado);
        return empleado;
    }
    @Transactional
    public Empleado removeMovimiento(Integer empl_id, Integer mov_id) throws Exception{
        Empleado empleado = readById(empl_id);
        MovimientoDinero movimientoDinero = mov_serv.findById(mov_id);
        empleado.removeMovimiento(movimientoDinero);
        return empleado;
    }
}
