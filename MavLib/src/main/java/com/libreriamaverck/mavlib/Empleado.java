package com.libreriamaverck.mavlib;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Scanner;

@AllArgsConstructor
@Data
public class Empleado {
    private String nombre;
    private String correo;
    private String empresa;
    private String rol;

    public static Empleado addEmpl(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre: ");
        String name = sc.nextLine();
        System.out.println("Ingrese el e-mail: ");
        String mail = sc.nextLine();
        System.out.println("Ingrese la empresa: ");
        String empr = sc.nextLine();
        System.out.println("ingrese el rol: ");
        String rol = sc.nextLine();
        Empleado empl1 = new Empleado(name, mail,empr, rol);
        return empl1;
    }

    public static Empleado modEmp(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nuevo nombre: ");
        String name = sc.nextLine();
        System.out.println("Ingrese el nuevo e-mail: ");
        String mail = sc.nextLine();
        System.out.println("Ingrese la nueva empresa: ");
        String empr = sc.nextLine();
        System.out.println("ingrese el nuevo rol: ");
        String rol = sc.nextLine();
        Empleado empl1 = new Empleado(name, mail,empr, rol);
        return empl1;
    }
}
