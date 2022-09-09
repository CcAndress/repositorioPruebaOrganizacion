package com.maverikteam.maverik.DTO;

import com.maverikteam.maverik.model.Empleado;
import com.maverikteam.maverik.model.MovimientoDinero;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data

public class EmpleadoDTO {
    private Integer id;
    private String nombre;
    private String correo;
    private PlainEmpresaDTO plainEmpresaDTO;
    private List<MovimientoDTO> movimientoDTO = new ArrayList<>();

    public static EmpleadoDTO from(Empleado empleado){
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        empleadoDTO.setId(empleado.getId());
        empleadoDTO.setNombre(empleado.getNombre());
        empleadoDTO.setCorreo(empleado.getCorreo());
        if(Objects.nonNull(empleado.getEmpresa())){
            empleadoDTO.setPlainEmpresaDTO(PlainEmpresaDTO.from(empleado.getEmpresa()));
        }
        empleadoDTO.setMovimientoDTO(empleado.getMov().stream().map(MovimientoDTO::from).collect(Collectors.toList()));
        return empleadoDTO;
    }
}
