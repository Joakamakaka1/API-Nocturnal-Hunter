package com.backend.nocturnalhunters.service;

import com.backend.nocturnalhunters.model.dto.EnemigosDTO;
import com.backend.nocturnalhunters.model.entity.Enemigos;

import java.util.List;

public interface EnemigosService {

    Enemigos buscarPorId(Integer id);

    boolean existeId(Integer id);

    List<Enemigos> listarEnemigos();
}
