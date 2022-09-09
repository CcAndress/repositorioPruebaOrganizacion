package com.maverikteam.maverik.Servicios.impl;

import com.maverikteam.maverik.Repositorios.EmpresaRepositorio;
import com.maverikteam.maverik.Servicios.IEmpresa;
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
public class EmpresaServicio implements IEmpresa {

    private final EmpresaRepositorio emp_repo;
    private final EmpleadoServicio emp_serv;

    private final MovimientoServicio mov_serv;
    @Autowired
    public EmpresaServicio(EmpresaRepositorio emp_repo, EmpleadoServicio emp_serv, MovimientoServicio mov_serv){
        this.emp_repo = emp_repo;
        this.emp_serv = emp_serv;
        this.mov_serv = mov_serv;
    }
    public List<Empresa> getEmpresas(){
        return this.emp_repo.findAll();
    }

    @Override
    public Empresa readById(Integer id) throws Exception {
        return this.emp_repo.findById(id).orElseThrow(() ->
                new EmpresaNotFoundException(id));
    }

    @Override
    public Empresa create(Empresa empresa) throws Exception {
        return this.emp_repo.save(empresa);
    }

    @Override
    public Empresa update(Empresa empresa) throws Exception {
        return this.emp_repo.save(empresa);
    }

    @Override
    public List<Empresa> readAll() throws Exception {
        return this.emp_repo.findAll();
    }

    @Override
    public void delete(Integer id) throws Exception {
        emp_repo.deleteById(id);
    }
    @Transactional
    public Empresa addEmpleado(Integer emp_id, Integer empl_id) throws Exception {
        Empresa empresa = readById(emp_id);
        Empleado empleado = emp_serv.readById(empl_id);
        if(Objects.nonNull(empleado.getEmpresa())){
            throw new ItemIsAlreadyAssigned(emp_id, empleado.getEmpresa().getId_ent());
        }
        empresa.addEmpleado(empleado);
        empleado.setEmpresa(empresa);
        return empresa;
    }
    @Transactional
    public Empresa removeEmpleado(Integer emp_id, Integer empl_id) throws Exception{
        Empresa empresa = readById(emp_id);
        Empleado empleado = emp_serv.readById(empl_id);
        empresa.removeEmpleado(empleado);
        return empresa;
    }

    @Transactional
    public Empresa addMov(Integer emp_id, Integer mov_id) throws Exception {
        Empresa empresa = readById(emp_id);
        MovimientoDinero movimientoDinero = mov_serv.findById(mov_id);
        if(Objects.nonNull(movimientoDinero.getEmpresa())){
            throw new ItemIsAlreadyAssigned(emp_id, movimientoDinero.getEmpresa().getId_ent());
        }
        empresa.addMov(movimientoDinero);
        movimientoDinero.setEmpresa(empresa);
        return empresa;
    }
    @Transactional
    public Empresa removeMov(Integer emp_id, Integer mov_id) throws Exception{
        Empresa empresa = readById(emp_id);
        MovimientoDinero movimientoDinero = mov_serv.findById(mov_id);
        empresa.removeMov(movimientoDinero);
        return empresa;
    }
}
