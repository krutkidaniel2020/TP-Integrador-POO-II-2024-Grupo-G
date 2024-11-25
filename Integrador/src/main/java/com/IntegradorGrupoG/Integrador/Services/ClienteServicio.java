package com.IntegradorGrupoG.Integrador.Services;

import com.IntegradorGrupoG.Integrador.models.Cliente;

import java.util.List;

/**
 * Interface del cliente
 */
public interface ClienteServicio {

    /**
     * Funcion que devuelve la lista de clientes
     * @return lista de clientes
     */
    List<Cliente> getClientes();

    /**
     * Funcion que elimina a un  cliente
     * @param id del cliente a eliminar
     */
    void eliminarCliente(int id);

    /**
     * Funcion que agrega un cliente
     * @param cliente a agregar
     */
    void agregarCliente(Cliente cliente);
}
