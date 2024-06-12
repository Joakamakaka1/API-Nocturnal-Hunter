package com.backend.nocturnalhunters.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ToString
@Builder
public class PartidasDTO implements Serializable {

    private Integer idPartidas;

    private LocalDateTime fechaHoraInicio;

    private String duracion;

    private String resultado;

    private Integer clienteID;

    private String nombrePj;

    private Integer enemigosEliminados;
}
