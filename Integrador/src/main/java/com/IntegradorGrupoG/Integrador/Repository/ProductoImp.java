package com.IntegradorGrupoG.Integrador.Repository;

import com.IntegradorGrupoG.Integrador.Services.ProductoServicio;
import com.IntegradorGrupoG.Integrador.models.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Clase que representa a la implementacion de Producto
 */
@Repository
@Transactional
public class ProductoImp implements ProductoServicio {

    /**
     * Interfaz de persistencia
     */
    @PersistenceContext
    EntityManager entityManager2;

    /**
     * Funcion que devuelve lista de productos
     * @return lista de productos
     */
    @Override
    public List<Producto> getProductos() {
        //String query = "FROM Cliente"; //Va el nombre de la Clase y no de la tabla bd aunque sean iguales
        String query = "FROM Producto"; //Va el nombre de la Clase y no de la tabla bd aunque sean iguales
        // return entityManager.createQuery(query).getResultList();
        List<Producto> unaL = entityManager2.createQuery(query).getResultList();
        return unaL;
    }


}
