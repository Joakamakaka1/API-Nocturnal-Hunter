package com.backend.nocturnalhunters.controllers;

import com.backend.nocturnalhunters.excepcion.ExcepcionRecursoNoEncontrado;
import com.backend.nocturnalhunters.model.dto.NivelesDTO;
import com.backend.nocturnalhunters.model.entity.Niveles;
import com.backend.nocturnalhunters.model.payload.MensajeResponse;
import com.backend.nocturnalhunters.service.NivelesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class NivelesController {

    @Autowired
    private NivelesService nivelesService;


    @GetMapping("niveles/{id}")
    public ResponseEntity<?> buscarNivelesId (@PathVariable Integer id){
        Niveles niveles = nivelesService.buscarPorId(id);
        if(niveles==null){
            throw new ExcepcionRecursoNoEncontrado("niveles","id",id);
        }else {
            NivelesDTO nivelesDTO = NivelesDTO.builder().idNiveles(niveles.getId()).nombreNivel(niveles.getNombreNivel()).descripcion(niveles.getDescripcion()).dificultad(niveles.getDificultad()).build();
            return new ResponseEntity<>(niveles, HttpStatus.OK);
        }
    }

    @GetMapping("niveles")
    public ResponseEntity<?> buscarNiveles (){
        List<Niveles> niveles  = nivelesService.listarNiveles();
        if(niveles == null || niveles.isEmpty()){
            throw new ExcepcionRecursoNoEncontrado("niveles");
        }else{
            return new ResponseEntity<>(MensajeResponse.builder().mensaje("Listado de niveles.").objeto(niveles).build(), HttpStatus.OK);
        }
    }
}
