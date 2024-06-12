package com.backend.nocturnalhunters.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
public class MejorasDTO {

    private Integer idMejoras;

    private String nombreMejora;

    private String buffo;

    private Integer precio;

    private Integer clienteId;

}

