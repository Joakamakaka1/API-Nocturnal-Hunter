package com.backend.nocturnalhunters.service.dao;

import com.backend.nocturnalhunters.model.dao.MejorasDAO;
import com.backend.nocturnalhunters.model.entity.Mejoras;
import com.backend.nocturnalhunters.service.MejorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MejorasImplements implements MejorasService {

    @Autowired
    private MejorasDAO mejorasDAO;
    @Override
    public Mejoras buscarPorId(Integer id) {
        return mejorasDAO.findById(id).orElse(null);
    }

    @Override
    public boolean existeId(Integer id) {
        return mejorasDAO.existsById(id);
    }

    @Override
    public List<Mejoras> listarMejoras() {
        return (List)mejorasDAO.findAll();
    }
}
