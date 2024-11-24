package com.IntegradorGrupoG.Integrador.Repository;

import com.IntegradorGrupoG.Integrador.models.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CategoriaDaoImp implements CategoriaDao{

    @PersistenceContext
    EntityManager entityManager1;

    @Override
    public List<Categoria> getCategorias() {
        //String query = "FROM Cliente"; //Va el nombre de la Clase y no de la tabla bd aunque sean iguales
        String query = "FROM Categoria"; //Va el nombre de la Clase y no de la tabla bd aunque sean iguales
        // return entityManager.createQuery(query).getResultList();
        List<Categoria> unaL = entityManager1.createQuery(query).getResultList();
        return unaL;
    }
}
