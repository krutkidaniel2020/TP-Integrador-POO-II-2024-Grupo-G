package com.IntegradorGrupoG.Integrador.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;


/**
 * Clase que representa al Cliente
 */
@Entity
//@Table(name = "cliente") //referencia a la tabla en mysql en este caso
@Getter @Setter @NoArgsConstructor
public class Cliente {

    /**
     * Variable id
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)

    @Id
    @Column(updatable = false)
    private Integer id;
    /**
     * Variable dni
     */
    @NotBlank
    @Size(min = 7, max = 12)
    @Column(nullable = false, length = 12)
    private String dni;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 50)

    private String apellido;

    /**
     * Variable nombre
     */
    @NotBlank
    @Size(min = 2, max = 60)
    @Column(nullable = false, length = 60)
    private String nombres;

    /**
     * Variable fecha
     */
    @NotBlank
    @Size(min = 2, max = 20)
    @Column(nullable = false, length = 20)
    private String fecha;

    /**
     * Variable direccion
     */
    @NotBlank
    @Size(min = 2, max = 70)
    @Column(nullable = false, length = 70)
    private String direccion;

    /**
     * Variable email
     */
    @NotBlank
    @Size(min = 2, max = 70)
    @Column(nullable = false, length = 70)
    private String email;

    /**
     * Variable tel
     */
    @NotBlank
    @Size(min = 0, max = 70)
    @Column(nullable = true, length = 70)
    private String tel;

    /**
     * Variable estado
     */
    @NotNull
    @Column(nullable = false)
    private boolean estado = true;


    /**
     * Variable pass
     */
    @NotBlank
    @Size(min = 2, max = 70)
    @Column(nullable = false, length = 70)
    private String pass;

    /**
     * Funcion que devuelve los atributos del cliente en formato json
     * @return atributos del cliente
     */


    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombres='" + nombres + '\'' +
                ", fecha='" + fecha + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", tel=" + tel +
                ", estado=" + estado +
                '}';
    }
    /* *//**
     * Funcion de buscar un objeto
     * @param o el obj a buscar
     * @return falso o el obj encontrado
     *//*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && tel == cliente.tel && Objects.equals(dni, cliente.dni) && Objects.equals(apellido, cliente.apellido) && Objects.equals(nombres, cliente.nombres) && Objects.equals(fecha, cliente.fecha) && Objects.equals(direccion, cliente.direccion) && Objects.equals(email, cliente.email);
    }*/

    /**
     * Metodo hash
     * @return el obj por hash
     *//*
    @Override
    public int hashCode() {
        return Objects.hash(id, dni, apellido, nombres, fecha, direccion, email, tel);
    }*/
}
