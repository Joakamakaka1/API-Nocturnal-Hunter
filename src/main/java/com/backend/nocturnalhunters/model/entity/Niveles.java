package com.backend.nocturnalhunters.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Niveles")
public class Niveles implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Nombre_Nivel")
    private String nombreNivel;

    @Column(name = "Descripción")
    private String descripcion;

    @Column(name = "Dificultad")
    private String dificultad;
}
