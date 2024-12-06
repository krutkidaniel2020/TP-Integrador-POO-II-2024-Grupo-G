package com.IntegradorGrupoG.Integrador.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa al Usuario
 */
@Entity
//@Table(name = "categoria")
@Getter @Setter @NoArgsConstructor
public class Usuario {

    /**
     * Variable id
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Id
    @Column(updatable = false)
    int id;

    /**
     * Variable dni
     */
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 255)
    String dni;

    /**
     * Variable pass
     */
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 255)
    String pass;

    /**
     * Variable categoria
     */
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 255)
    String privilegio;

    /**
     * Baja de Usuario.
     */
    @NotNull
    @Column(nullable = false)
    private boolean baja = false;

}
