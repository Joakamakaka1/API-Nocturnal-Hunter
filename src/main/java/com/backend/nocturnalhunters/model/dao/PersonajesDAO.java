package com.backend.nocturnalhunters.model.dao;

import com.backend.nocturnalhunters.model.entity.Personajes;
import org.springframework.data.repository.CrudRepository;

public interface PersonajesDAO extends CrudRepository<Personajes, Integer> {
}
