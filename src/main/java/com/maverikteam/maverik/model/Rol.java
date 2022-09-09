package com.maverikteam.maverik.model;



import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
@Data
@AllArgsConstructor
@Entity
@Table(name="Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="Rol")
    private String rol;

//    @ManyToOne
//    @JoinColumn(name="idRol", nullable = false)
//    private Empleado empleado;

    public Rol() {

    }


}
