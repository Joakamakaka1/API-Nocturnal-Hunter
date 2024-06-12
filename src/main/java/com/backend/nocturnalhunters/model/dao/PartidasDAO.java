package com.backend.nocturnalhunters.model.dao;

import com.backend.nocturnalhunters.model.entity.Partidas;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PartidasDAO extends CrudRepository<Partidas, Integer> {
    List<Partidas> findByClienteID(Integer id);
}
