package com.backend.nocturnalhunters.service;

import com.backend.nocturnalhunters.model.entity.Mejoras;

import java.util.List;

public interface MejorasService {

    Mejoras buscarPorId(Integer id);

    boolean existeId(Integer id);
    List<Mejoras> listarMejoras();
}
