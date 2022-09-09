package com.maverikteam.maverik.Controlador;

import com.maverikteam.maverik.DTO.EmpleadoDTO;
import com.maverikteam.maverik.DTO.EmpresasDTO;
import com.maverikteam.maverik.DTO.MovimientoDTO;
import com.maverikteam.maverik.Servicios.impl.EmpleadoServicio;
import com.maverikteam.maverik.Servicios.impl.EmpresaServicio;
import com.maverikteam.maverik.Servicios.impl.MovimientoServicio;
import com.maverikteam.maverik.exceptions.ModelNotFoundException;
import com.maverikteam.maverik.model.Empleado;
import com.maverikteam.maverik.model.Empresa;
import com.maverikteam.maverik.model.MovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmpresaController {

    private final EmpresaServicio serv;
    private final MovimientoServicio sermov;

    private final EmpleadoServicio servempl;

    @Autowired
    public EmpresaController(EmpresaServicio serv, MovimientoServicio sermov, EmpleadoServicio servempl) {
        this.serv = serv;
        this.sermov = sermov;
        this.servempl = servempl;
    }



    @GetMapping("/empresas")
    public ResponseEntity<List<EmpresasDTO>> getEmpresas() {
        List<Empresa> empresas = serv.getEmpresas();
        List<EmpresasDTO> empresasDTOS = empresas.stream().map(EmpresasDTO::from).collect(Collectors.toList());
        return new ResponseEntity<>(empresasDTOS, HttpStatus.OK);
    }

    @PostMapping("/empresas")
    public ResponseEntity<EmpresasDTO> create(@RequestBody EmpresasDTO empresasDTO) throws Exception {
        Empresa empresa = serv.create(Empresa.from(empresasDTO));
        return new ResponseEntity<>(EmpresasDTO.from(empresa), HttpStatus.OK);
    }

    @GetMapping("/empresas/{id}")
    public ResponseEntity<EmpresasDTO> readById(@PathVariable("id") Integer id) throws Exception {
        Empresa empresa = serv.readById(id);
        return new ResponseEntity<>(EmpresasDTO.from(empresa), HttpStatus.OK);
    }

    @PatchMapping("/empresas/{id}")
    public ResponseEntity<EmpresasDTO> update(@PathVariable("id") Integer id, @RequestBody EmpresasDTO emp) throws Exception {
        Empresa empresa = serv.readById(id);
        if (empresa == null) {
            throw new ModelNotFoundException("Id no encontrado: " + id);
        } else {
            empresa.setNombre(emp.getNombre());
            empresa.setDireccion(emp.getDireccion());
            empresa.setNIT(emp.getNIT());
            empresa.setTelefono(emp.getTelefono());
            empresa.setEmpleados(emp.getEmpleadosDTO().stream().map(Empleado::from).collect(Collectors.toList()));

        }
        return new ResponseEntity<>(EmpresasDTO.from(empresa), HttpStatus.OK);
    }

    @PutMapping("/empresas")
    public Empresa update(@RequestBody Empresa emp) throws Exception {
        return this.serv.update(emp);
    }

    @DeleteMapping("/empresas/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        serv.delete(id);
    }

    @PostMapping("/empresas/{emp_id}/empleados/{empl_id}/add")
    public ResponseEntity<EmpresasDTO> addEmpleado(@PathVariable final Integer emp_id,
                                                   @PathVariable final Integer empl_id) throws Exception {
        Empresa empresa = serv.addEmpleado(emp_id, empl_id);
        return new ResponseEntity<>(EmpresasDTO.from(empresa), HttpStatus.OK);
    }

    @DeleteMapping("/empresas/{id}/empleados/{empl_id}/remove")
    public ResponseEntity<EmpresasDTO> removeEmpleado(@PathVariable final Integer emp_id,
                                                   @PathVariable final Integer empl_id) throws Exception {
        Empresa empresa = serv.removeEmpleado(emp_id, empl_id);
        return new ResponseEntity<>(EmpresasDTO.from(empresa), HttpStatus.OK);
    }

    @GetMapping("/empresas/{id}/movimiento/{mov_id}")
    public ResponseEntity<List<MovimientoDTO>> getMovimientoDinero(@PathVariable final Integer id,
                                                                   @PathVariable final Integer mov_id) throws Exception {
        Empresa empresa = serv.readById((id));
        List<MovimientoDinero> movimientoDinero = sermov.getMovimientoDinero();
        List<MovimientoDTO> movimientoDTOS = movimientoDinero.stream().map(MovimientoDTO::from).collect(Collectors.toList());
        return new ResponseEntity<>(movimientoDTOS, HttpStatus.OK);
    }
    @PostMapping("/movimiento")
    public ResponseEntity<MovimientoDTO> create(@RequestBody final MovimientoDTO movimientoDTO) throws Exception {
        MovimientoDinero movimientoDinero = sermov.create(MovimientoDinero.from(movimientoDTO));
        return new ResponseEntity<>(MovimientoDTO.from(movimientoDinero), HttpStatus.OK);
    }
    @PostMapping("/empresas/{emp_id}/movimiento/{mov_id}/add")
    public ResponseEntity<EmpresasDTO> addMov(@PathVariable final Integer emp_id,
                                                   @PathVariable final Integer mov_id) throws Exception {
        Empresa empresa = serv.addMov(emp_id, mov_id);
        return new ResponseEntity<>(EmpresasDTO.from(empresa), HttpStatus.OK);
    }

    @DeleteMapping("/empresas/{id}/empleados/{mov_id}/remove")
    public ResponseEntity<EmpresasDTO> removeMov(@PathVariable final Integer emp_id,
                                                      @PathVariable final Integer empl_id) throws Exception {
        Empresa empresa = serv.removeMov(emp_id, empl_id);
        return new ResponseEntity<>(EmpresasDTO.from(empresa), HttpStatus.OK);
    }


//    @PatchMapping("/empresas/{id}/movimiento/{mov_id}")
//    public ResponseEntity<MovimientoDTO> update(@PathVariable("id") Integer id,
//                                              @PathVariable("mov_id") Integer mov_id,
//                                              @RequestBody MovimientoDinero mov) throws Exception {
//        MovimientoDinero movimientoDinero = sermov.findById(id);
//        if (movimientoDinero == null) {
//            throw new ModelNotFoundException("Id no encontrado: " + id);
//        } else {
//            movimientoDinero.setId_mov(mov.getId_mov());
//            movimientoDinero.setMonto(mov.getMonto());
//            movimientoDinero.setTipo(mov.getTipo());
//            movimientoDinero.setConcepto(mov.getConcepto());
//            movimientoDinero.setEmpleado(mov.getEmpleado());
//
////        }
//        return new ResponseEntity<>(MovimientoDTO.from(movimientoDinero), HttpStatus.OK);
//    }
//    @PostMapping("/empresas/{emp_id}/empleados/{empl_id}/add")
//    public ResponseEntity<EmpleadoDTO> addMovimiento(@PathVariable final Integer empl_id,
//                                                   @PathVariable final Integer mov_id) throws Exception {
//        Empleado empleado = servempl.addMovimiento(empl_id, mov_id);
//        return new ResponseEntity<>(EmpleadoDTO.from(empleado), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/empresas/{id}/movimiento/{mov_id}/remove")
//    public ResponseEntity<EmpleadoDTO> removeMovimiento(@PathVariable final Integer empl_id,
//                                                      @PathVariable final Integer mov_id) throws Exception {
//        Empleado empleado = servempl.removeMovimiento(empl_id, mov_id);
//        return new ResponseEntity<>(EmpleadoDTO.from(empleado), HttpStatus.OK);
//    }
}

