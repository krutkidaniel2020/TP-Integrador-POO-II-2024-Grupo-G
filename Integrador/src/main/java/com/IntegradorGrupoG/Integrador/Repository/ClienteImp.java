package com.IntegradorGrupoG.Integrador.Repository;

import com.IntegradorGrupoG.Integrador.Services.ClienteServicio;
import com.IntegradorGrupoG.Integrador.models.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Clase que representa a la implementacion de Cliente
 */
@Repository
@Transactional
public class ClienteImp implements ClienteServicio {

    /**
     * Interfaz de persistencia
     */
    @PersistenceContext
     EntityManager entityManager1;

    /**
     * Funcion que devuelve lista de clientes
     * @return lista de clientes
     */
    @Override
    public List<Cliente> getClientes() {
        String query = "FROM Cliente"; //Va el nombre de la Clase y no de la tabla bd aunque sean iguales
        List<Cliente> unaL = entityManager1.createQuery(query).getResultList();
        return unaL;
    }

    /**
     * Funcion eliminar cliente
     * @param id del cliente
     */
    @Override
    public void eliminarCliente(int id) {
        Cliente unCliente = entityManager1.find(Cliente.class,id);
        entityManager1.remove(unCliente);
    }

    /**
     * Funcion agregar cliente
     * @param cliente a agregar
     */
    @Override
    public void agregarCliente(Cliente cliente) {
       entityManager1.merge(cliente);
    }

}
