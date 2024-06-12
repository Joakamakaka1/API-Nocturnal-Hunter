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
@Table(name = "Mejoras")
public class Mejoras implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Nombre_Mejora")
    private String nombreMejora;

    @Column(name = "Buffo")
    private String buffo;

    @Column(name = "Precio")
    private Integer precio;

    @Column(name = "ClienteID")
    private Integer clienteID;

}
