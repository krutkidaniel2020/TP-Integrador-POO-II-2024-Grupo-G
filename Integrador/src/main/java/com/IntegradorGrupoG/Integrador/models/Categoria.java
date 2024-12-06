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
 * Clase que representa a Categoria
 */
@Entity
//@Table(name = "categoria")
@Getter @Setter @NoArgsConstructor
public class Categoria {

    /**
     * Variable id de la categ
     */
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    @Id
  //  @Column(name = "id")  @Getter //@Setter
    @Column(updatable = false)
    private Integer id;

    /**
     * Variable nombre de la categ
     */
    //@Column(name = "nombre") @Getter @Setter
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 255)
    private String nombre;

    /**
     * Define si esta habilitado categ.
     */
    @NotNull
    @Column(nullable = false)
    private boolean estado = true;

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
