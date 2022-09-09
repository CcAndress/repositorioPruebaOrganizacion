package com.maverikteam.maverik.model;

import com.maverikteam.maverik.DTO.MovimientoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Scanner;

@Data
@AllArgsConstructor
@Entity
@Table(name="Movimiento")
public class MovimientoDinero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_mov;
    @Column(name="Monto")
    private double monto;
    @Column(name="Tipo")
    private String tipo;
    @Column(name= "Concepto")
    private String concepto;
    @ManyToOne
    private Empleado empleado;
    @ManyToOne Empresa empresa;

    public MovimientoDinero(){

    }
    public static MovimientoDinero from(MovimientoDTO movimientoDTO){
        MovimientoDinero movimientoDinero = new MovimientoDinero();
        movimientoDinero.setId_mov(movimientoDTO.getId_mov());
        movimientoDinero.setMonto(movimientoDTO.getMonto());
        movimientoDinero.setTipo(movimientoDTO.getTipo());
        movimientoDinero.setConcepto(movimientoDTO.getConcepto());
        return movimientoDinero;
    }
}
