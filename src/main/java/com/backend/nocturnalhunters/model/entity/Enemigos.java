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
@Table(name = "Enemigos")

public class Enemigos implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Tipo")
    private String tipo;

    @Column(name = "Vida")
    private Integer vida;

    @Column(name = "Daño")
    private Integer daño;

    @Column(name = "Velocidad")
    private Integer velocidad;
}
