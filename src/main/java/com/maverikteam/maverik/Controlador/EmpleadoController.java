package com.maverikteam.maverik.Controlador;

import com.maverikteam.maverik.DTO.EmpleadoDTO;
import com.maverikteam.maverik.Servicios.impl.EmpleadoServicio;
import com.maverikteam.maverik.exceptions.ModelNotFoundException;
import com.maverikteam.maverik.model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmpleadoController {

    EmpleadoServicio servicio;
    @Autowired
    public EmpleadoController(EmpleadoServicio emp){
        this.servicio= emp;
    }

    @GetMapping("/empleados")
    public ResponseEntity<List<EmpleadoDTO>> getEmpleados(){
        List<Empleado> empleados = servicio.getEmpleados();
        List<EmpleadoDTO> empleadoDTOS = empleados.stream().map(EmpleadoDTO::from).collect(Collectors.toList());
        return new ResponseEntity<>(empleadoDTOS, HttpStatus.OK);

    }

    @PostMapping("/empleados")
    public ResponseEntity<EmpleadoDTO> create(@RequestBody final EmpleadoDTO empleadoDTO) throws Exception {
        Empleado empleado = servicio.create(Empleado.from(empleadoDTO));
        return new ResponseEntity<>(EmpleadoDTO.from(empleado), HttpStatus.OK);
    }
    @GetMapping("/empleados/{id}")
    public ResponseEntity<EmpleadoDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Empleado empleado = servicio.readById(id);
        return new ResponseEntity<>(EmpleadoDTO.from(empleado), HttpStatus.OK);
    }
    @PatchMapping("/empleados/{id}")
    public ResponseEntity<EmpleadoDTO> update(@PathVariable("id") Integer id, @RequestBody EmpleadoDTO empleadoDTO) throws Exception{
        Empleado empleado = servicio.readById(id);
        if(empleado == null){
            throw new ModelNotFoundException("Id no encontrado: " + id);
        }
        else{
            empleado.setNombre(empleadoDTO.getNombre());
            empleado.setCorreo(empleadoDTO.getCorreo());

        }
        return new ResponseEntity<>(EmpleadoDTO.from(empleado), HttpStatus.OK);
    }
    @PutMapping("/empleados")
    public Empleado update(@RequestBody Empleado emp) throws Exception {
        if(emp == null){
            throw new ModelNotFoundException("usuario no encontrado: " + emp);
        }
        return this.servicio.update(emp);
    }
    @DeleteMapping("/empleados/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        servicio.delete(id);
    }

}
