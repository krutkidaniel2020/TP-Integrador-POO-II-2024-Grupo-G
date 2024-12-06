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
 * Clase que representa a Producto
 */
@Entity
@Getter @Setter @NoArgsConstructor
public class Producto {

    /**
     * Variable id
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)

    @Id
    @Column(updatable = false)
    int id;

    /**
     * Variable nombre
     */
    @NotBlank
    @Size(min = 2, max = 150)
    @Column(nullable = false, length = 150)
    String nombre;

    /**
     * Variable marca
     */
    @NotBlank
    @Size(min = 2, max = 150)
    @Column(nullable = false, length = 150)
    String marca;

    /**
     * Variable descripcion
     */
    @NotBlank
    @Size(min = 2, max = 150)
    @Column(nullable = false, length = 150)
    String descripcion;

    /**
     * Variable precio
     */

    @Column(nullable = false)
    double precio;

    /**
     * Variable cantidad
     */

    @Column(nullable = false)
    int cantidad;

    /**
     * Variable una categoria a la que pertenece el producto
     */
  /*  @Column(nullable = false)
    int idcateg;*/
    @NotNull
    @ManyToOne
    Categoria categoria;

    /**
     * Variable estado
     */
    @NotNull
    @Column(nullable = false)
    private boolean estado = true;


}
