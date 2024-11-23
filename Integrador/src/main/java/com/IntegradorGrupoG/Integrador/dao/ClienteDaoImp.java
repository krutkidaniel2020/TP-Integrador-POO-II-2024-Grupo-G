package com.IntegradorGrupoG.Integrador.dao;

import com.IntegradorGrupoG.Integrador.models.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public class ClienteDaoImp implements ClienteDao{

    @PersistenceContext
     EntityManager entityManager;

    @Override
    public List<Cliente> getClientes() {
        String query = "FROM Cliente"; //Va el nombre de la Clase y no de la tabla bd aunque sean iguales
       //return entityManager.createNamedQuery(query).getResultList();
        return entityManager.createQuery(query).getResultList();

    }
}
