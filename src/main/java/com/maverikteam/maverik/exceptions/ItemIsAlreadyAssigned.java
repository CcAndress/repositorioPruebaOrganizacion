package com.maverikteam.maverik.exceptions;

import java.text.MessageFormat;

public class ItemIsAlreadyAssigned extends RuntimeException{
    public ItemIsAlreadyAssigned(final Integer emp_id, final Integer empl_id){
        super(MessageFormat.format("El empleado {0} ya fue asignado a la empresa {1}: ", empl_id, emp_id));

    }
}
