package com.IntegradorGrupoG.Integrador.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase que representa al Usuario
 */
@Entity
@Table(name = "usuario") //referencia a la tabla en mysql en este caso
public class Usuario {

    /**
     * Variable id
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")  @Getter @Setter
    int id;

    /**
     * Variable dni
     */
    @Column(name = "dni") @Getter @Setter
    String dni;

    /**
     * Variable pass
     */
    @Column(name = "pass") @Getter @Setter
    String pass;

    /**
     * Variable categoria
     */
    @Column(name = "categoria") @Getter @Setter
    String categoria;



}
