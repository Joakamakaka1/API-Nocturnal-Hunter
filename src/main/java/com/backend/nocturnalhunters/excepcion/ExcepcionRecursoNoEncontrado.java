package com.backend.nocturnalhunters.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExcepcionRecursoNoEncontrado extends RuntimeException{
    private String nombreRecurso;
    private String campo;
    private Object valor;

    public ExcepcionRecursoNoEncontrado(String nombreRecurso, String campo, Object valor){
        super((nombreRecurso+" no fue encontrado con "+campo+valor));
        this.nombreRecurso=nombreRecurso;
        this.campo=campo;
        this.valor=valor;
    }

    public ExcepcionRecursoNoEncontrado(String nombreRecurso){
        super(("No hay "+nombreRecurso+" actualmente en el sistema."));
        this.nombreRecurso=nombreRecurso;
    }
}
