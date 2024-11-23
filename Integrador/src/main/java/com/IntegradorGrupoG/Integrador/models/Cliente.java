package com.IntegradorGrupoG.Integrador.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.Objects;
//import javax.persistence.Entity;
//import javax.persistence.Table;

@Entity
@Table(name = "Cliente") //referencia a la tabla en mysql en este caso

public class Cliente {
    @Column(name = "idCliente")
    @Id
    private int idCliente;
    @Column(name = "dni")
    private String dni;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fechaNac")
    private Date fechaNac;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "email")
    private String email;
    @Column(name = "tel")
    private int tel;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", dni='" + dni + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaNac=" + fechaNac +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", tel=" + tel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return idCliente == cliente.idCliente && tel == cliente.tel && Objects.equals(dni, cliente.dni) && Objects.equals(apellido, cliente.apellido) && Objects.equals(nombre, cliente.nombre) && Objects.equals(fechaNac, cliente.fechaNac) && Objects.equals(direccion, cliente.direccion) && Objects.equals(email, cliente.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, dni, apellido, nombre, fechaNac, direccion, email, tel);
    }
}
