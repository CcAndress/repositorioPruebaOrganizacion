package com.maverikteam.maverik.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

public class GlobalErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleModelNotFound(ModelNotFoundException ex, WebRequest request){
        ErrorDTO dto = new ErrorDTO(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
