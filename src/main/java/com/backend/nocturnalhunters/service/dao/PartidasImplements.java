package com.backend.nocturnalhunters.service.dao;

import com.backend.nocturnalhunters.model.dao.PartidasDAO;
import com.backend.nocturnalhunters.model.dto.PartidasDTO;
import com.backend.nocturnalhunters.model.entity.Partidas;
import com.backend.nocturnalhunters.service.PartidaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidasImplements implements PartidaService {
    @Autowired
    private PartidasDAO partidasDAO;
    @Transactional
    @Override
    public Partidas guardarPartidas(PartidasDTO partidasDTO) {
        Partidas partidas = Partidas.builder().id(partidasDTO.getIdPartidas()).fechaHoraInicio(partidasDTO.getFechaHoraInicio()).duracion(partidasDTO.getDuracion()).resultado(partidasDTO.getResultado()).clienteID(partidasDTO.getClienteID()).nombrePj(partidasDTO.getNombrePj()).enemigosEliminados(partidasDTO.getEnemigosEliminados()).build();
        return partidasDAO.save(partidas);
    }

    @Override
    public List<Partidas> buscarPorID(Integer id) {
        return partidasDAO.findByClienteID(id);
    }

    @Override
    public boolean existeId(Integer id) {
        return partidasDAO.existsById(id);
    }

    @Override
    public List<Partidas> listarPartidas() {
        return (List)partidasDAO.findAll();
    }
}