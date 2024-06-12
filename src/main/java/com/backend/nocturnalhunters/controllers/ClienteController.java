package com.backend.nocturnalhunters.controllers;

import com.backend.nocturnalhunters.excepcion.ExcepcionBadRequest;
import com.backend.nocturnalhunters.excepcion.ExcepcionRecursoNoEncontrado;
import com.backend.nocturnalhunters.model.dto.ClienteDTO;
import com.backend.nocturnalhunters.model.entity.Cliente;
import com.backend.nocturnalhunters.model.payload.MensajeResponse;
import com.backend.nocturnalhunters.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Cliente controller.
 */
@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    /**
     * Crear cliente response entity.
     *
     * @param clienteDTO the cliente dto
     * @return the response entity
     */
    @PostMapping("cliente")
    public ResponseEntity<?> crearCliente(@RequestBody @Valid ClienteDTO clienteDTO){
        Cliente cliente = null;
        try{
            cliente = clienteService.guardarUsuario(clienteDTO);
            clienteDTO = ClienteDTO.builder().idUsuario(cliente.getId()).usuario(cliente.getUsuario()).gmail(cliente.getGmail()).password(cliente.getPassword()).build();

            return new ResponseEntity<>(MensajeResponse.builder().mensaje("El cliente se ha creado con exito.").objeto(clienteDTO).build(), HttpStatus.CREATED);
        }catch(DataAccessException e){
            throw new ExcepcionBadRequest(e.getMessage());
        }
    }

    /**
     * Modificar cliente response entity.
     *
     * @param clienteDTO the cliente dto
     * @param id         the id
     * @return the response entity
     */
    @PutMapping("cliente/{id}")
    public ResponseEntity<?> modificarCliente(@RequestBody @Valid ClienteDTO clienteDTO,@PathVariable Integer id){
        Cliente cliente = null;
        try{
            if(clienteService.existeId(id)) {
                clienteDTO.setIdUsuario(id);
                cliente = clienteService.guardarUsuario(clienteDTO);
                clienteDTO = ClienteDTO.builder().idUsuario(cliente.getId()).usuario(cliente.getUsuario()).gmail(cliente.getGmail()).password(cliente.getPassword()).build();

                return new ResponseEntity<>(MensajeResponse.builder().mensaje("El Cliente se ha modificado con exito.").objeto(clienteDTO).build(), HttpStatus.CREATED);
            }else{
                throw new ExcepcionRecursoNoEncontrado("cliente","id",id);
            }
        }catch(DataAccessException e){
            throw new ExcepcionBadRequest(e.getMessage());
        }
    }

    /**
     * Eliminar cliente response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("cliente/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable Integer id){

        try{
            Cliente cliente = clienteService.buscarPorID(id);
            clienteService.eliminar(cliente);
            return new ResponseEntity<>(MensajeResponse.builder().mensaje("Cliente eliminado con exito.").objeto(null).build(),HttpStatus.OK);
        }catch(DataAccessException e){
            throw new ExcepcionBadRequest(e.getMessage());
        }
    }

    /**
     * Buscar cliente id response entity .
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("cliente/{id}")
    public ResponseEntity <?> buscarClienteId (@PathVariable Integer id){
        Cliente cliente = clienteService.buscarPorID(id);
        if(cliente==null){
            throw new ExcepcionRecursoNoEncontrado("usuario","id",id);
        }else {
            ClienteDTO clienteDTO = ClienteDTO.builder().idUsuario(cliente.getId()).usuario(cliente.getUsuario()).gmail(cliente.getGmail()).password(cliente.getPassword()).build();
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
    }

    /**
     * Buscar clientes response entity .
     *
     * @return the response entity
     */
    @GetMapping("clientes")
    public ResponseEntity <?> buscarClientes (){
        List <Cliente> clientes  = clienteService.listarUsuarios();

        if(clientes == null || clientes.isEmpty()){
            throw new ExcepcionRecursoNoEncontrado("clientes");
        }else{
            return new ResponseEntity<>(MensajeResponse.builder().mensaje("Listado de clientes.").objeto(clientes).build(),HttpStatus.OK);
        }
    }
}


