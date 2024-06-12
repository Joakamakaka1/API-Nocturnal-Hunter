package com.backend.nocturnalhunters.service.dao;

import com.backend.nocturnalhunters.model.dao.ClienteDAO;
import com.backend.nocturnalhunters.model.dto.ClienteDTO;
import com.backend.nocturnalhunters.model.entity.Cliente;
import com.backend.nocturnalhunters.service.ClienteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Cliente implements.
 */
@Service
public class ClienteImplements implements ClienteService {
    @Autowired
    private ClienteDAO clienteDAO;

    /**
     * Saves a new user to the database.
     *
     * @param  clienteDTO  the DTO containing the user information to be saved
     * @return             the saved user object
     */
    @Transactional
    @Override
    public Cliente guardarUsuario(ClienteDTO clienteDTO) {
        Cliente cliente = Cliente.builder().id(clienteDTO.getIdUsuario()).usuario(clienteDTO.getUsuario()).gmail(clienteDTO.getGmail()).password(clienteDTO.getPassword()).build();
        return clienteDAO.save(cliente);
    }

    /**
     * Retrieves a Cliente object from the clienteDAO repository by its ID.
     *
     * @param  id  the ID of the Cliente object to retrieve
     * @return     the Cliente object with the specified ID, or null if not found
     */
    @Override
    public Cliente buscarPorID(Integer id) {
        return clienteDAO.findById(id).orElse(null);
    }

    /**
     * Deletes a Cliente object from the clienteDAO repository.
     *
     * @param  usuario  the Cliente object to be deleted
     */
    @Override
    public void eliminar(Cliente usuario) {
        clienteDAO.delete(usuario);
    }

    /**
     * Checks if the given ID exists in the clienteDAO.
     *
     * @param  id  the ID to check
     * @return     true if the ID exists, false otherwise
     */
    @Override
    public boolean existeId(Integer id) {
        return clienteDAO.existsById(id);
    }

    /**
     * Retrieves a list of all users.
     *
     * @return  a list of Cliente objects representing all users
     */
    @Override
    public List<Cliente> listarUsuarios() {
        return (List)clienteDAO.findAll();
    }
}