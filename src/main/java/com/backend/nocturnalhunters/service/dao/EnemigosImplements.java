package com.backend.nocturnalhunters.service.dao;

import com.backend.nocturnalhunters.model.dao.EnemigosDAO;
import com.backend.nocturnalhunters.model.entity.Enemigos;
import com.backend.nocturnalhunters.service.EnemigosService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnemigosImplements implements EnemigosService {
    @Autowired
    private EnemigosDAO enemigosDAO;
    @Transactional
    @Override
    public Enemigos buscarPorId(Integer id) {
        return enemigosDAO.findById(id).orElse(null);
    }

    @Override
    public boolean existeId(Integer id) {
        return enemigosDAO.existsById(id);
    }

    @Override
    public List<Enemigos> listarEnemigos() {
        return (List)enemigosDAO.findAll();
    }
}
