package com.IntegradorGrupoG.Integrador.Repository;


import com.IntegradorGrupoG.Integrador.Services.UsuarioServicio;
import com.IntegradorGrupoG.Integrador.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class UsuarioImp implements UsuarioServicio {

    @PersistenceContext
    EntityManager entityManager3;

    @Override
    public List<Usuario> getUsuarios() {

        String query = "FROM Usuario"; //Va el nombre de la Clase y no de la tabla bd aunque sean iguales
        // return entityManager.createQuery(query).getResultList();
        List<Usuario> unU = entityManager3.createQuery(query).getResultList();
        return unU;
    }

    public Usuario obtenerUsuarioCredenciales(Usuario usuario){
        //String email = "'OR 1 = 1 --'";
        //String query = "FROM Usuario WHERE dni = :dni and pass = :pass"; //Va el nombre de la Clase y no de la tabla bd aunque sean iguales
        String query = "FROM Usuario WHERE dni = :dni "; //Va el nombre de la Clase y no de la tabla bd aunque sean iguales
        List<Usuario> usuarios = entityManager3.createQuery(query)
                .setParameter("dni",usuario.getDni())
                .getResultList();
       if (usuarios.isEmpty()){
         return null;
       }
       //else{
        //    return true;
       // }

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
       //return argon2.verify(usuarios.get(0).getPass(),usuario.getPass());


       if(argon2.verify(usuarios.get(0).getPass(),usuario.getPass()))
        {
            return usuarios.get(0);
        }
    //return !usuarios.isEmpty();
        return null;

    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        entityManager3.merge(usuario);
    }
}
