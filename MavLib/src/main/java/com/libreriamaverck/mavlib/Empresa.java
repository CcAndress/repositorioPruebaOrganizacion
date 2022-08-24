package com.libreriamaverck.mavlib;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Scanner;

@Data
@AllArgsConstructor
public class Empresa {
    private String nombre;
    private String direccion;
    private String telefono;
    private String NIT;

    public static Empresa addEmp(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la empresa: ");
        String name = sc.nextLine();
        System.out.println("Ingrese la dirección: ");
        String dir = sc.nextLine();
        System.out.println("Ingrese el teléfono: ");
        String tel = sc.nextLine();
        System.out.println("ingrese el NIT: ");
        String nit = sc.nextLine();
        Empresa emp1 = new Empresa(name, dir,tel, nit);
        return emp1;
    }

    public static Empresa modEmp(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nuevo nombre: ");
        String name = sc.nextLine();
        System.out.println("Ingrese la nueva dirección: ");
        String dir = sc.nextLine();
        System.out.println("Ingrese el nuevo teléfono: ");
        String tel = sc.nextLine();
        System.out.println("ingrese el nuevo NIT: ");
        String nit = sc.nextLine();
        Empresa emp1 = new Empresa(name, dir,tel, nit);
        return emp1;
    }
}


