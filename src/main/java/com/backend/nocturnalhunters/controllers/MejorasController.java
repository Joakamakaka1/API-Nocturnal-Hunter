package com.backend.nocturnalhunters.controllers;

import com.backend.nocturnalhunters.excepcion.ExcepcionRecursoNoEncontrado;
import com.backend.nocturnalhunters.model.dto.MejorasDTO;
import com.backend.nocturnalhunters.model.dto.PersonajesDTO;
import com.backend.nocturnalhunters.model.entity.Mejoras;
import com.backend.nocturnalhunters.model.entity.Personajes;
import com.backend.nocturnalhunters.model.payload.MensajeResponse;
import com.backend.nocturnalhunters.service.MejorasService;
import com.backend.nocturnalhunters.service.PersonajesService;
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
public class MejorasController {

    @Autowired
    private MejorasService mejorasService;

    @GetMapping("mejoras/{id}")
    public ResponseEntity<?> buscarMejorasId (@PathVariable Integer id){
        Mejoras mejoras = mejorasService.buscarPorId(id);
        if(mejoras==null){
            throw new ExcepcionRecursoNoEncontrado("mejoras","id",id);
        }else {
            MejorasDTO mejorasDTO = MejorasDTO.builder()
                    .idMejoras(mejoras.getId())
                    .nombreMejora(mejoras.getNombreMejora())
                    .buffo(mejoras.getBuffo())
                    .precio(mejoras.getPrecio())
                    .clienteId(mejoras.getClienteID())
                    .build();
            return new ResponseEntity<>(mejoras, HttpStatus.OK);
        }
    }

    @GetMapping("mejoras")
    public ResponseEntity <?> buscarMejoras (){
        List<Mejoras> mejoras  = mejorasService.listarMejoras();

        if(mejoras == null || mejoras.isEmpty()){
            throw new ExcepcionRecursoNoEncontrado("mejoras");
        }else{
            return new ResponseEntity<>(MensajeResponse.builder().mensaje("Listado de mejoras.").objeto(mejoras).build(),HttpStatus.OK);
        }
    }
}
