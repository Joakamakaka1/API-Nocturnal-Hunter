package com.backend.nocturnalhunters.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class PersonajesDTO implements Serializable {

    private Integer idPersonajes;

    private String nombre;

    private String tipo;

    private String vida;

    private String daño;

    private String velocidad;

    private String clienteID;

}
