package com.IntegradorGrupoG.Integrador.Repository;

import com.IntegradorGrupoG.Integrador.models.Cliente;

import java.util.List;

public interface ClienteDao {

List<Cliente> getClientes();


    void elimunarCliente(int id);

    void agregarCliente(Cliente cliente);
}
