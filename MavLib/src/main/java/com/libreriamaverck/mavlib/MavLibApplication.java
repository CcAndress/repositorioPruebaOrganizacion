package com.libreriamaverck.mavlib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class MavLibApplication {

    public static void main(String[] args) {
        SpringApplication.run(MavLibApplication.class, args);

        Scanner sc = new Scanner(System.in);
        List<Empresa> empresas = new ArrayList<>();
        System.out.println("¿Cuántas empresas desea agregar? ");
        int num_emp = sc.nextInt();

        for (int i=0; i<num_emp;i++){
            Empresa emp= Empresa.addEmp();
            empresas.add(emp);
        }


        System.out.println("Desea ver los datos de las empresas? (S/N)");
        String resp = sc.next();
        if (resp.equalsIgnoreCase("S")){
            for(int i=0;i< empresas.size();i++){
                System.out.println(empresas.get(i));
            }

        }

        System.out.println("¿Desea modificar los datos de una empresa? (S/N) ");
        String resp_mod = sc.next();
        if (resp_mod.equalsIgnoreCase("S")){
            System.out.println("ingresa el nombre de la empresa a modificar");
            String nom= sc.nextLine();
            for(int i=0;i<empresas.size();i++){
                if(empresas.get(i).getNombre().equalsIgnoreCase(nom)){
                    Empresa emp1= Empresa.modEmp();
                    empresas.add(emp1);
                }
            }
        }

        List<Empleado> empleados = new ArrayList<>();
        System.out.println("¿Cuántas empresas desea agregar? ");
        int num_empl = sc.nextInt();

        for (int i=0; i<num_empl;i++){
            Empleado empl= Empleado.addEmpl();
            empleados.add(empl);
        }

        System.out.println("Desea ver los datos del empleado? (S/N)");
        String op_emp = sc.next();
        if (op_emp.equalsIgnoreCase("S")){
            for(int i=0;i< empleados.size();i++){
                System.out.println(empleados.get(i));
            }

        }

        System.out.println("¿Desea modificar los datos de un empleado? (S/N) ");
        String emp_mod = sc.next();
        if (emp_mod.equalsIgnoreCase("S")){
            System.out.println("ingresa el nombre del empleado a modificar");
            String nom_emp= sc.nextLine();
            for(int i=0;i<empleados.size();i++){
                if(empresas.get(i).getNombre().equalsIgnoreCase(nom_emp)){
                    Empleado emp1= Empleado.modEmp();
                    System.out.println(emp1);
                }
            }
        }
    }
}
