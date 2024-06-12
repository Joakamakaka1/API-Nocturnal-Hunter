package com.backend.nocturnalhunters.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Partidas")
public class Partidas implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Fecha_Hora_inicio")
    private LocalDateTime fechaHoraInicio;

    @Column(name = "Duración")
    private String duracion;

    @Column(name = "Resultado")
    private String resultado;

    @Column(name = "ClienteID")
    private Integer clienteID;

    @Column(name = "Nombre_Pj")
    private String nombrePj;

    @Column(name = "Enemigos_Eliminados")
    private Integer enemigosEliminados;
}
