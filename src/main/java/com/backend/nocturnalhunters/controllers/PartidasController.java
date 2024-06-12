package com.backend.nocturnalhunters.controllers;

import com.backend.nocturnalhunters.excepcion.ExcepcionBadRequest;
import com.backend.nocturnalhunters.excepcion.ExcepcionRecursoNoEncontrado;
import com.backend.nocturnalhunters.model.dto.PartidasDTO;
import com.backend.nocturnalhunters.model.entity.Partidas;
import com.backend.nocturnalhunters.model.payload.MensajeResponse;
import com.backend.nocturnalhunters.service.PartidaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PartidasController {

    @Autowired
    private PartidaService partidaService;

    @PostMapping("partidas")
    public ResponseEntity<?> crearPartida(@RequestBody @Valid PartidasDTO partidaDTO){
        Partidas partida = null;
        try{
            partida = partidaService.guardarPartidas(partidaDTO);
            partidaDTO = partidaDTO.builder().idPartidas(partida.getId()).fechaHoraInicio(partida.getFechaHoraInicio()).duracion(partida.getDuracion()).resultado(partida.getResultado()).clienteID(partida.getClienteID()).nombrePj(partida.getNombrePj()).enemigosEliminados(partida.getEnemigosEliminados()).build();

            return new ResponseEntity<>(MensajeResponse.builder().mensaje("La partida se ha creado con exito.").objeto(partidaDTO).build(), HttpStatus.CREATED);
        }catch(DataAccessException e){
            throw new ExcepcionBadRequest(e.getMessage());
        }
    }

    @PutMapping("partidas/{id}")
    public ResponseEntity<?> modificarPartida(@RequestBody @Valid PartidasDTO partidaDTO,@PathVariable Integer id){
        Partidas partida = null;
        try{
            if(partidaService.existeId(id)) {
                partidaDTO.setIdPartidas(id);
                partida = partidaService.guardarPartidas(partidaDTO);
                partidaDTO = partidaDTO.builder().idPartidas(partida.getId()).fechaHoraInicio(partida.getFechaHoraInicio()).duracion(partida.getDuracion()).resultado(partida.getResultado()).clienteID(partida.getClienteID()).nombrePj(partida.getNombrePj()).enemigosEliminados(partida.getEnemigosEliminados()).build();

                return new ResponseEntity<>(MensajeResponse.builder().mensaje("La partida se ha modificado con exito.").objeto(partidaDTO).build(), HttpStatus.CREATED);
            }else{
                throw new ExcepcionRecursoNoEncontrado("partida","id",id);
            }
        }catch(DataAccessException e){
            throw new ExcepcionBadRequest(e.getMessage());
        }
    }

    @GetMapping("partidas/{id}")
    public ResponseEntity <?> buscarPartidaId (@PathVariable Integer id){
        List <Partidas> partidas = partidaService.buscarPorID(id);

        if(partidas == null || partidas.isEmpty()){
            throw new ExcepcionRecursoNoEncontrado("partidas");
        }else{
            return new ResponseEntity<>(MensajeResponse.builder().mensaje("Listado de partidas.").objeto(partidas).build(),HttpStatus.OK);
        }
    }

    @GetMapping("partidas")
    public ResponseEntity <?> buscarPartidas (){
        List <Partidas> partidas  = partidaService.listarPartidas();

        if(partidas == null || partidas.isEmpty()){
            throw new ExcepcionRecursoNoEncontrado("partidas");
        }else{
            return new ResponseEntity<>(MensajeResponse.builder().mensaje("Listado de partidas.").objeto(partidas).build(),HttpStatus.OK);
        }
    }
}
