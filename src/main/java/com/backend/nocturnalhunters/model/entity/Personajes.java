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
@Table(name = "Personajes")
public class Personajes implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Tipo")
    private String tipo;

    @Column(name = "Vida")
    private String vida;

    @Column(name = "Daño")
    private String daño;

    @Column(name = "Velocidad")
    private String velocidad;

    @Column(name = "ClienteID")
    private String clienteID;
}
