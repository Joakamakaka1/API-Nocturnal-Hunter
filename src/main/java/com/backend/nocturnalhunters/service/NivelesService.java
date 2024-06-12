package com.backend.nocturnalhunters.service;

import com.backend.nocturnalhunters.model.entity.Niveles;

import java.util.List;

public interface NivelesService {

    Niveles buscarPorId(Integer id);

    boolean existeId(Integer id);

    List<Niveles> listarNiveles();
}
