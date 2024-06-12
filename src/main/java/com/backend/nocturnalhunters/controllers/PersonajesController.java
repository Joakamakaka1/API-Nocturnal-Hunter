package com.backend.nocturnalhunters.controllers;

import com.backend.nocturnalhunters.excepcion.ExcepcionRecursoNoEncontrado;
import com.backend.nocturnalhunters.model.dto.EnemigosDTO;
import com.backend.nocturnalhunters.model.dto.PersonajesDTO;
import com.backend.nocturnalhunters.model.entity.Enemigos;
import com.backend.nocturnalhunters.model.entity.Personajes;
import com.backend.nocturnalhunters.model.payload.MensajeResponse;
import com.backend.nocturnalhunters.service.EnemigosService;
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
public class PersonajesController {

    @Autowired
    private PersonajesService personajesService;

    @GetMapping("personajes/{id}")
    public ResponseEntity<?> buscarPersonajesId (@PathVariable Integer id){
        Personajes personajes = personajesService.buscarPorId(id);
        if(personajes==null){
            throw new ExcepcionRecursoNoEncontrado("personaje","id",id);
        }else {
            PersonajesDTO personajesDTO = PersonajesDTO.builder().idPersonajes(personajes.getId()).nombre(personajes.getNombre()).tipo(personajes.getTipo()).vida(personajes.getVida()).daño(personajes.getDaño()).velocidad(personajes.getVelocidad()).build();
            return new ResponseEntity<>(personajes, HttpStatus.OK);
        }
    }

    @GetMapping("personajes")
    public ResponseEntity <?> buscarPersonajes (){
        List<Personajes> personajes  = personajesService.listarPersonajes();

        if(personajes == null || personajes.isEmpty()){
            throw new ExcepcionRecursoNoEncontrado("personajes");
        }else{
            return new ResponseEntity<>(MensajeResponse.builder().mensaje("Listado de personajes.").objeto(personajes).build(),HttpStatus.OK);
        }
    }
}
