package com.backend.nocturnalhunters.excepcion;

import com.backend.nocturnalhunters.model.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExcepcionGlobal {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handlerElementoNoValido(MethodArgumentNotValidException e, WebRequest webRequest){
        Map<String,String> errorMapa = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) ->{
            String clave = ((FieldError)error).getField();
            String valor = error.getDefaultMessage();
            errorMapa.put(clave,valor);
        }
        );
        ApiResponse apiResponse = new ApiResponse(errorMapa.toString(),webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ExcepcionRecursoNoEncontrado.class)
    public ResponseEntity<ApiResponse> handlerRecursoNoEncontrado(ExcepcionRecursoNoEncontrado e, WebRequest webRequest){
        ApiResponse apiResponse = new ApiResponse(e.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExcepcionBadRequest.class)
    public ResponseEntity<ApiResponse> handlerBadRequest(ExcepcionRecursoNoEncontrado e, WebRequest webRequest){
        ApiResponse apiResponse = new ApiResponse(e.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handlerException(ExcepcionRecursoNoEncontrado e, WebRequest webRequest){
        ApiResponse apiResponse = new ApiResponse(e.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
