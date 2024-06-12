package com.backend.nocturnalhunters.model.dao;

import com.backend.nocturnalhunters.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Cliente dao.
 */
public interface ClienteDAO extends CrudRepository <Cliente, Integer> {

}
