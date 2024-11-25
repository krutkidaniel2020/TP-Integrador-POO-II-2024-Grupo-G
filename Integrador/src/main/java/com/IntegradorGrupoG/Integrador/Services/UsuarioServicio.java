package com.IntegradorGrupoG.Integrador.Services;


import com.IntegradorGrupoG.Integrador.models.Usuario;
import java.util.List;

/**
 * Interface del Usuario
 */
public interface UsuarioServicio {

    /**
     * Funcion que devuelve la lista de usuarios
     * @return lista de usuarios
     */
    List<Usuario> getUsuarios();

    /**
     * Funcion agregar usuario
     * @param usuario a agregar
     */
    void agregarUsuario(Usuario usuario);

    /**
     * Funcion para obtener las credenciales de usuario
     * @param usuario a buscar
     * @return null o el usuario encontrado
     */
    Usuario obtenerUsuarioCredenciales(Usuario usuario);
}
