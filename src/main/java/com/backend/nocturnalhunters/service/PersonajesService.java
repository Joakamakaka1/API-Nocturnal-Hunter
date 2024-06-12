package com.backend.nocturnalhunters.service;

import com.backend.nocturnalhunters.model.entity.Personajes;

import java.util.List;

public interface PersonajesService {

    Personajes buscarPorId(Integer id);

    boolean existeId(Integer id);

    List<Personajes> listarPersonajes();
}
