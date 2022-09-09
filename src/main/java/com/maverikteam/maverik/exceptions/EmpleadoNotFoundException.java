package com.maverikteam.maverik.exceptions;

import java.text.MessageFormat;

public class EmpleadoNotFoundException extends RuntimeException{
    public EmpleadoNotFoundException(Integer id) {
        super(MessageFormat.format("no se encontró el id de empleado {0}", id));
    }
}
