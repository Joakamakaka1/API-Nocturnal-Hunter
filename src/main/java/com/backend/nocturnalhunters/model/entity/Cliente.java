package com.backend.nocturnalhunters.model.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

/**
 * The type Cliente.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Clientes")

public class Cliente implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Gmail")
    private String gmail;

    @Column(name = "Usuario")
    private String usuario;

    @Column(name = "Contraseña")
    private String password;

    /*
    @ManyToOne
    @JoinColumn(name = "ID")
    private Cliente usuario;
    */
}
