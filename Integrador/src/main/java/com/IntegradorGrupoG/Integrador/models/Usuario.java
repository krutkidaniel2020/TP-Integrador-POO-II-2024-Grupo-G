package com.IntegradorGrupoG.Integrador.models;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario") //referencia a la tabla en mysql en este caso
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    int id;
    @Column(name = "dni")
    String dni;
    @Column(name = "pass")
    String pass;
    @Column(name = "categoria")
    String categoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
