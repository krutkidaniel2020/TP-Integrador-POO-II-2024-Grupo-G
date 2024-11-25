package com.IntegradorGrupoG.Integrador.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


/**
 * Clase que representa a Categoria
 */
@Entity
@Table(name = "categoria")
public class Categoria {

    /**
     * Variable id de la categ
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")  @Getter @Setter
    private int id;

    /**
     * Variable nombre de la categ
     */
    @Column(name = "nombre") @Getter @Setter
    private String nombre;


    /**
     * Funcion que devuelve los atributos de la categoria
     * @return un los atributos en formato json
     */
    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
