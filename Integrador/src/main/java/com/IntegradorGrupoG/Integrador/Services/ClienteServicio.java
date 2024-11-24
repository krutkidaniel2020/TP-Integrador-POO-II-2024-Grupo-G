package com.IntegradorGrupoG.Integrador.Services;

import com.IntegradorGrupoG.Integrador.models.Cliente;

import java.util.List;

public interface ClienteServicio {

List<Cliente> getClientes();


    void eliminarCliente(int id);

    void agregarCliente(Cliente cliente);
}
