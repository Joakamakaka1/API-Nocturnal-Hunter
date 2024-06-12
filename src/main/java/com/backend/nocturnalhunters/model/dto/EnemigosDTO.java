package com.backend.nocturnalhunters.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class EnemigosDTO implements Serializable {

    private Integer idEnemigos;

    private String nombre;
    private String tipo;
    private Integer vida;
    private Integer daño;
    private Integer velocidad;
}
