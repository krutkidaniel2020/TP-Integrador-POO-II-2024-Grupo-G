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

/**
 * Clase que representa a la implementacion de Usuario
 */
@Repository
@Transactional
public class UsuarioImp implements UsuarioServicio {

    /**
     * Interfaz de persistencia
     */
    @PersistenceContext
    EntityManager entityManager3;

    /**
     * Funcion que devuelve lista de usuarios
     * @return lista de usuarios
     */
    @Override
    public List<Usuario> getUsuarios() {

        String query = "FROM Usuario"; //Va el nombre de la Clase y no de la tabla bd aunque sean iguales
        List<Usuario> unU = entityManager3.createQuery(query).getResultList();
        return unU;
    }

    /**
     * Funcion para obtener las credenciales de usuario
     * @param usuario usuario a buscar
     * @return null o el usuario encontrado
     */
    public Usuario obtenerUsuarioCredenciales(Usuario usuario){
        //String email = "'OR 1 = 1 --'"; hack
        String query = "FROM Usuario WHERE dni = :dni "; //Va el nombre de la Clase y no de la tabla bd aunque sean iguales
        List<Usuario> usuarios = entityManager3.createQuery(query)
                .setParameter("dni",usuario.getDni())
                .getResultList();
       if (usuarios.isEmpty()){
         return null;
       }
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
       if(argon2.verify(usuarios.get(0).getPass(),usuario.getPass()))
        {
            return usuarios.get(0);
        }
            //return !usuarios.isEmpty();
        return null;

    }

    /**
     * Funcion agregar usuario
     * @param usuario usuario que se agrega
     */
    @Override
    public void agregarUsuario(Usuario usuario) {
        entityManager3.merge(usuario);
    }
}
