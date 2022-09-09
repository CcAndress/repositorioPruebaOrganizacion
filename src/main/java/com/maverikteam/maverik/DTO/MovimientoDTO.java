package com.maverikteam.maverik.DTO;

import com.maverikteam.maverik.model.Empleado;
import com.maverikteam.maverik.model.MovimientoDinero;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
public class MovimientoDTO {
    private Integer id_mov;
    private double monto;
    private String tipo;
    private String concepto;
    private PlainEmpleadoDTO emple_ref;
    private PlainEmpresaDTO Empr_ref;

    public static MovimientoDTO from(MovimientoDinero movimientoDinero){
        MovimientoDTO movimientoDTO = new MovimientoDTO();
        movimientoDTO.setId_mov(movimientoDinero.getId_mov());
        movimientoDTO.setMonto(movimientoDinero.getMonto());
        movimientoDTO.setConcepto(movimientoDinero.getConcepto());
        if(Objects.nonNull(movimientoDinero.getEmpleado())){
            movimientoDTO.setEmple_ref(PlainEmpleadoDTO.from(movimientoDinero.getEmpleado()));
        }
        if(Objects.nonNull(movimientoDinero.getEmpresa())){
            movimientoDTO.setEmpr_ref(PlainEmpresaDTO.from(movimientoDinero.getEmpresa()));
        }
        return movimientoDTO;
    }
}
