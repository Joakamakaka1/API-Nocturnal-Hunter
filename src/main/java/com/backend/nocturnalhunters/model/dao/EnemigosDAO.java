package com.backend.nocturnalhunters.model.dao;

import com.backend.nocturnalhunters.model.entity.Enemigos;
import org.springframework.data.repository.CrudRepository;

public interface EnemigosDAO extends CrudRepository<Enemigos, Integer> {
}
