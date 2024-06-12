package com.backend.nocturnalhunters.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import jakarta.validation.constraints.*;

import java.io.Serializable;

/**
 * The type Cliente dto.
 */
@Data
@ToString
@Builder
public class ClienteDTO implements Serializable {

    private Integer idUsuario;

    @Size(min = 3, max = 30)
    @NotEmpty(message = "Debe ingresar el nombre.")
    private String usuario;

    @Size(min = 4, max = 10)
    @NotEmpty(message = "Debe ingresar una contraseña.")
    private String password;

    @Size(min = 8, max = 40)
    @NotEmpty(message = "Debe ingresar una contraseña.")
    private String gmail;
}
