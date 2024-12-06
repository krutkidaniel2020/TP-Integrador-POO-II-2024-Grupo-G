package com.IntegradorGrupoG.Integrador.Services;

public class EntidadNoEncontradaExcepcion extends RuntimeException{
    EntidadNoEncontradaExcepcion(int id) {
        super("Entidad no encontrada: " + id);
    }
}
