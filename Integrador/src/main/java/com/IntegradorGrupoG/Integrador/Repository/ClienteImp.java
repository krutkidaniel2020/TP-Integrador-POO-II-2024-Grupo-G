package com.IntegradorGrupoG.Integrador.Repository;

import com.IntegradorGrupoG.Integrador.Services.ClienteServicio;
import com.IntegradorGrupoG.Integrador.models.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public class ClienteImp implements ClienteServicio {

    @PersistenceContext
     EntityManager entityManager1;

    @Override
    public List<Cliente> getClientes() {
        //String query = "FROM Cliente"; //Va el nombre de la Clase y no de la tabla bd aunque sean iguales
        String query = "FROM Cliente"; //Va el nombre de la Clase y no de la tabla bd aunque sean iguales
       // return entityManager.createQuery(query).getResultList();
        List<Cliente> unaL = entityManager1.createQuery(query).getResultList();
        return unaL;
    }

    @Override
    public void elimunarCliente(int id) {
        Cliente unCliente = entityManager1.find(Cliente.class,id);
        entityManager1.remove(unCliente);
    }

    @Override
    public void agregarCliente(Cliente cliente) {
       entityManager1.merge(cliente);
    }

}
