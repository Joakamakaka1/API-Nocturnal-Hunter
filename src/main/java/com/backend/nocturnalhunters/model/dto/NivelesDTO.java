package com.backend.nocturnalhunters.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class NivelesDTO {

    private Integer idNiveles;

    private String nombreNivel;

    private String descripcion;

    private String dificultad;
}
