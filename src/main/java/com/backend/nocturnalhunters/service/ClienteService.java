package com.backend.nocturnalhunters.service;

import com.backend.nocturnalhunters.model.dto.ClienteDTO;
import com.backend.nocturnalhunters.model.entity.Cliente;

import java.util.List;

/**
 * The interface Cliente service.
 */
public interface ClienteService {

    /**
     * Guardar usuario cliente.
     *
     * @param usuario the usuario
     * @return the cliente
     */
    Cliente guardarUsuario(ClienteDTO usuario);

    /**
     * Buscar por id cliente.
     *
     * @param id the id
     * @return the cliente
     */
    Cliente buscarPorID(Integer id);

    /**
     * Eliminar.
     *
     * @param usuario the usuario
     */
    void eliminar(Cliente usuario);

    /**
     * Existe id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean existeId(Integer id);

    /**
     * Listar usuarios list.
     *
     * @return the list
     */
    List<Cliente> listarUsuarios();
}
