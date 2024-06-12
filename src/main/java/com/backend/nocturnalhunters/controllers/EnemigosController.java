package com.backend.nocturnalhunters.controllers;

import com.backend.nocturnalhunters.excepcion.ExcepcionRecursoNoEncontrado;
import com.backend.nocturnalhunters.model.dto.EnemigosDTO;
import com.backend.nocturnalhunters.model.entity.Enemigos;
import com.backend.nocturnalhunters.model.payload.MensajeResponse;
import com.backend.nocturnalhunters.service.EnemigosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EnemigosController {

    @Autowired
    private EnemigosService enemigosService;

    @GetMapping("enemigos/{id}")
    public ResponseEntity<?> buscarEnemigosId (@PathVariable Integer id){
        Enemigos enemigos = enemigosService.buscarPorId(id);
        if(enemigos==null){
            throw new ExcepcionRecursoNoEncontrado("enemigo","id",id);
        }else {
            EnemigosDTO enemigosDTO = EnemigosDTO.builder().idEnemigos(enemigos.getId()).nombre(enemigos.getNombre()).tipo(enemigos.getTipo()).vida(enemigos.getVida()).daño(enemigos.getDaño()).velocidad(enemigos.getVelocidad()).build();
            return new ResponseEntity<>(enemigos, HttpStatus.OK);
        }
    }

    /**
     * Buscar clientes response entity .
     *
     * @return the response entity
     */
    @GetMapping("enemigos")
    public ResponseEntity <?> buscarEnemigos (){
        List<Enemigos> enemigos  = enemigosService.listarEnemigos();

        if(enemigos == null || enemigos.isEmpty()){
            throw new ExcepcionRecursoNoEncontrado("enemigos");
        }else{
            return new ResponseEntity<>(MensajeResponse.builder().mensaje("Listado de enemigos.").objeto(enemigos).build(),HttpStatus.OK);
        }
    }
}
