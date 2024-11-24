package com.IntegradorGrupoG.Integrador.Services;

import com.IntegradorGrupoG.Integrador.models.Cliente;

import java.util.List;

public interface ClienteServicio {

List<Cliente> getClientes();


    void elimunarCliente(int id);

    void agregarCliente(Cliente cliente);
}
