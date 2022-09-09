package com.maverikteam.maverik.DTO;

import com.maverikteam.maverik.model.Empleado;
import com.maverikteam.maverik.model.Empresa;
import com.maverikteam.maverik.model.MovimientoDinero;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class EmpresasDTO {

    private Integer id_ent;
    private String nombre;
    private String direccion;
    private Integer telefono;
    private String NIT;
    private List<EmpleadoDTO> empleadosDTO = new ArrayList<>();
    private List<MovimientoDTO> movimientoDTOS = new ArrayList<>();

    public static EmpresasDTO from(Empresa empresa){
        EmpresasDTO empresasDTO = new EmpresasDTO();
        empresasDTO.setId_ent(empresa.getId_ent());
        empresasDTO.setNombre(empresa.getNombre());
        empresasDTO.setDireccion(empresa.getDireccion());
        empresasDTO.setTelefono(empresa.getTelefono());
        empresasDTO.setNIT(empresa.getNIT());
        empresasDTO.setEmpleadosDTO(empresa.getEmpleados().stream().map(EmpleadoDTO::from).collect(Collectors.toList()));
        empresasDTO.setMovimientoDTOS(empresa.getMovimientos().stream().map(MovimientoDTO::from).collect(Collectors.toList()));
        return empresasDTO;
    }
}
