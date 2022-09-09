package com.maverikteam.maverik.model;

import com.maverikteam.maverik.DTO.EmpleadoDTO;
import com.maverikteam.maverik.DTO.EmpresasDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Entity
@Table(name="Empresas")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ent;
    @Column(name="nombre")
    private String nombre;
    @Column(name="Dirección")
    private String direccion;
    @Column(name="Teléfono")
    private Integer telefono;
    @Column(name="NIT")
    private String NIT;

    @OneToMany(
            targetEntity = Empleado.class,
            cascade = CascadeType.MERGE,
            orphanRemoval = true
    )
    @JoinColumn(name= "e_fk", referencedColumnName = "id_ent")
    private List<Empleado> empleados;

    @OneToMany(
            targetEntity = MovimientoDinero.class,
            cascade = CascadeType.MERGE,
            orphanRemoval = true
    )
    @JoinColumn(name= "mpv_fk", referencedColumnName = "id_ent")
    private List<MovimientoDinero> movimientos;

    public void addEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    public void removeEmpleado(Empleado empleado){
        empleados.remove(empleado);
    }

   public void addMov(MovimientoDinero movimientoDinero){
        movimientos.add(movimientoDinero);
   }

    public void removeMov(MovimientoDinero movimientoDinero){
        movimientos.remove(movimientoDinero);
    }
    public Empresa (){

    }
    public static Empresa from(EmpresasDTO empresasDTO){
        Empresa empresa = new Empresa();
        empresa.setId_ent(empresasDTO.getId_ent());
        empresa.setNombre(empresasDTO.getNombre());
        empresa.setDireccion(empresasDTO.getDireccion());
        empresa.setTelefono(empresasDTO.getTelefono());
        empresa.setNIT(empresasDTO.getNIT());
        empresa.setEmpleados(empresasDTO.getEmpleadosDTO().stream().map(Empleado::from).collect(Collectors.toList()));
        empresa.setMovimientos(empresasDTO.getMovimientoDTOS().stream().map(MovimientoDinero::from).collect(Collectors.toList()));
        return empresa;
    }

}