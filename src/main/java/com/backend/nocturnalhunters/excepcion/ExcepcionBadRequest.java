package com.backend.nocturnalhunters.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ExcepcionBadRequest extends RuntimeException{
    public ExcepcionBadRequest(String mensaje){
        super(mensaje);
    };
}
