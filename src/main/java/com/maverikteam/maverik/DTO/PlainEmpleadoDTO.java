package com.maverikteam.maverik.DTO;

import com.maverikteam.maverik.model.Empleado;
import lombok.Data;

@Data
public class PlainEmpleadoDTO {
    private Integer id;
    private String name;

    public static PlainEmpleadoDTO from(Empleado empleado){
        PlainEmpleadoDTO movPorEmp = new PlainEmpleadoDTO();
        movPorEmp.setId(empleado.getId());
        movPorEmp.setName(empleado.getNombre());
        return movPorEmp;
    }
}
