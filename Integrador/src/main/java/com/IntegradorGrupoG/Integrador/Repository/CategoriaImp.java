package com.IntegradorGrupoG.Integrador.Repository;

import com.IntegradorGrupoG.Integrador.Services.CategoriaServicio;
import com.IntegradorGrupoG.Integrador.models.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
/**
 * Clase que representa a la implementacion de categoria
 */
public class CategoriaImp implements CategoriaServicio {

    /**
     * Interfaz de persistencia
     */
    @PersistenceContext
    EntityManager entityManager1;

    /**
     * Funcion que devuelve lista de categorias
     * @return lista de categorias
     */
    @Override
    public List<Categoria> getCategorias() {
        String query = "FROM Categoria"; //Va el nombre de la Clase y no de la tabla bd aunque sean iguales
        List<Categoria> unaL = entityManager1.createQuery(query).getResultList();
        return unaL;
    }
}
