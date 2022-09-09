package com.maverikteam.maverik.exceptions;

import org.aspectj.bridge.Message;

import java.text.MessageFormat;

public class EmpresaNotFoundException extends RuntimeException{
    public EmpresaNotFoundException(Integer id){
        super(MessageFormat.format("no se encontró el id {0}", id));
    }
}
