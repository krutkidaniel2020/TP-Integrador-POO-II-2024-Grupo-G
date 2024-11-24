package com.IntegradorGrupoG.Integrador.Repository;


import com.IntegradorGrupoG.Integrador.Services.UsuarioServicio;
import com.IntegradorGrupoG.Integrador.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioServicio {

    @PersistenceContext
    EntityManager entityManager3;

    @Override
    public List<Usuario> getUsuarios() {

        String query = "FROM Usuario"; //Va el nombre de la Clase y no de la tabla bd aunque sean iguales
        // return entityManager.createQuery(query).getResultList();
        List<Usuario> unU = entityManager3.createQuery(query).getResultList();
        return unU;
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        entityManager3.merge(usuario);
    }
}
