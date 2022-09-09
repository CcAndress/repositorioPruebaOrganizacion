package com.maverikteam.maverik.model;

import com.maverikteam.maverik.DTO.EmpleadoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Entity
@Table(name="Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Correo")
    private String correo;
    @ManyToOne
    private Empresa empresa;
    @OneToMany(
            targetEntity = MovimientoDinero.class,
            cascade = CascadeType.MERGE,
            orphanRemoval = true
    )
    @JoinColumn(name= "mov_fk", referencedColumnName = "id")
    private List<MovimientoDinero> mov;

    public Empleado() {
    }
//
    public static Empleado from(EmpleadoDTO empleadoDTO){
        Empleado empleado = new Empleado();
        empleado.setNombre(empleadoDTO.getNombre());
        empleado.setCorreo(empleadoDTO.getCorreo());
        empleado.setMov(empleadoDTO.getMovimientoDTO().stream().map(MovimientoDinero::from).collect(Collectors.toList()));
        return empleado;
    }

    public void addMovimiento(MovimientoDinero movimientoDinero){
        mov.add(movimientoDinero);
    }

    public void removeMovimiento(MovimientoDinero movimientoDinero){
        mov.remove(movimientoDinero);
    }

}

