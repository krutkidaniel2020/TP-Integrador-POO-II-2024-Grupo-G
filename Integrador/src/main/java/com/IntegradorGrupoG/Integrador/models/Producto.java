package com.IntegradorGrupoG.Integrador.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase que representa a Producto
 */
@Entity
@Table(name = "producto") //referencia a la tabla en mysql en este caso
public class Producto {

    /**
     * Variable id
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id") @Getter @Setter
    int id;

    /**
     * Variable nombre
     */
    @Column(name = "nombre") @Getter @Setter
    String nombre;

    /**
     * Variable marca
     */
    @Column(name = "marca") @Getter @Setter
    String marca;

    /**
     * Variable descripcion
     */
    @Column(name = "descripcion") @Getter @Setter
    String descripcion;

    /**
     * Variable precio
     */
    @Column(name = "precio") @Getter @Setter
    double precio;

    /**
     * Variable cantidad
     */
    @Column(name = "cantidad") @Getter @Setter
    int cantidad;

    /**
     * Variable categoria
     */
    @Column(name = "categoria") @Getter @Setter
    int categoria;




}
