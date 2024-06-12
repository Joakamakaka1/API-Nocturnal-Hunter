package com.backend.nocturnalhunters.service;

import com.backend.nocturnalhunters.model.dto.PartidasDTO;
import com.backend.nocturnalhunters.model.entity.Partidas;

import java.util.List;

/**
 * The interface Partida service.
 */
public interface PartidaService {

    Partidas guardarPartidas(PartidasDTO usuario);
    List<Partidas> buscarPorID(Integer id);
    boolean existeId(Integer id);
    List<Partidas> listarPartidas();
}
