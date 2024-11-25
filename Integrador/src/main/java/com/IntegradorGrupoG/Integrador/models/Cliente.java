package com.IntegradorGrupoG.Integrador.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Objects;


/**
 * Clase que representa al Cliente
 */
@Entity
@Table(name = "cliente") //referencia a la tabla en mysql en este caso
public class Cliente {

    /**
     * Variable id
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id") @Getter @Setter
    private int id;

    /**
     * Variable dni
     */
    @Column(name = "dni") @Getter @Setter
    private String dni;

    /**
     * Variable apellido
     */
    @Column(name = "apellido") @Getter @Setter
    private String apellido;

    /**
     * Variable nombre
     */
    @Column(name = "nombre") @Getter @Setter
    private String nombre;

    /**
     * Variable fecha
     */
    @Column(name = "fecha") @Getter @Setter
    private String fecha;

    /**
     * Variable direccion
     */
    @Column(name = "direccion") @Getter @Setter
    private String direccion;

    /**
     * Variable email
     */
    @Column(name = "email") @Getter @Setter
    private String email;

    /**
     * Variable tel
     */
    @Column(name = "tel") @Getter @Setter
    private int tel;

    /**
     * Funcion que devuelve los atributos del cliente en formato json
     * @return atributos del cliente
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + id +
                ", dni='" + dni + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaNac=" + fecha +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", tel=" + tel +
                '}';
    }

    /**
     * Funcion de buscar un objeto
     * @param o el obj a buscar
     * @return falso o el obj encontrado
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && tel == cliente.tel && Objects.equals(dni, cliente.dni) && Objects.equals(apellido, cliente.apellido) && Objects.equals(nombre, cliente.nombre) && Objects.equals(fecha, cliente.fecha) && Objects.equals(direccion, cliente.direccion) && Objects.equals(email, cliente.email);
    }

    /**
     * Metodo hash
     * @return el obj por hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, dni, apellido, nombre, fecha, direccion, email, tel);
    }
}
