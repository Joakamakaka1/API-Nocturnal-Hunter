package com.backend.nocturnalhunters.service.dao;

import com.backend.nocturnalhunters.model.dao.NivelesDAO;
import com.backend.nocturnalhunters.model.entity.Niveles;
import com.backend.nocturnalhunters.service.NivelesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NivelesImplements implements NivelesService {

    @Autowired
    NivelesDAO nivelesDAO;

    @Override
    public Niveles buscarPorId(Integer id) {
        return nivelesDAO.findById(id).orElse(null);
    }

    @Override
    public boolean existeId(Integer id) {
        return nivelesDAO.existsById(id);
    }

    @Override
    public List<Niveles> listarNiveles() {
        return (List)nivelesDAO.findAll();
    }
}
