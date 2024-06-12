package com.backend.nocturnalhunters.service.dao;

import com.backend.nocturnalhunters.model.dao.PersonajesDAO;
import com.backend.nocturnalhunters.model.entity.Personajes;
import com.backend.nocturnalhunters.service.PersonajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajesImplements implements PersonajesService {

    @Autowired
    private PersonajesDAO personajesDAO;

    @Override
    public Personajes buscarPorId(Integer id) {
        return personajesDAO.findById(id).orElse(null);
    }

    @Override
    public boolean existeId(Integer id) {
        return personajesDAO.existsById(id);
    }

    @Override
    public List<Personajes> listarPersonajes() {
        return (List)personajesDAO.findAll();
    }
}
