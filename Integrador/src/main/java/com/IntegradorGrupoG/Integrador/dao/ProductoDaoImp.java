package com.IntegradorGrupoG.Integrador.dao;

import com.IntegradorGrupoG.Integrador.models.Cliente;
import com.IntegradorGrupoG.Integrador.models.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductoDaoImp implements ProductoDao{
    @PersistenceContext
    EntityManager entityManager2;

    @Override
    public List<Producto> getProductos() {
        //String query = "FROM Cliente"; //Va el nombre de la Clase y no de la tabla bd aunque sean iguales
        String query = "FROM Producto"; //Va el nombre de la Clase y no de la tabla bd aunque sean iguales
        // return entityManager.createQuery(query).getResultList();
        List<Producto> unaL = entityManager2.createQuery(query).getResultList();
        return unaL;
    }

}
