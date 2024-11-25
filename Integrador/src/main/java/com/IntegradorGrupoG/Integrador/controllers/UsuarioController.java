package com.IntegradorGrupoG.Integrador.controllers;



import com.IntegradorGrupoG.Integrador.Services.UsuarioServicio;

import com.IntegradorGrupoG.Integrador.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Controlador de Usuario
 */
@RestController
public class UsuarioController {

    /**
     * Variable unUsuarioServicio para la iny de dependencias
     */
    @Autowired
    private UsuarioServicio unUsuarioServicio; //inyeccion de dependencias

    /**
     * Funcion que devuelve la lista de usuarios
     * @return lista de usuarios
     */
    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(){
        return unUsuarioServicio.getUsuarios();

    }

    /**
     * Funcion para agregar usuario
     * @param usuario a agregar
     */
    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void agregarUsuario(@RequestBody Usuario usuario){ //convierte lo que recibe en usuario
    Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
      String hash=  argon2.hash(1, 1024, 1, usuario.getPass()); //Parametro primero es cant de iteraciones de modif, segundo espacio mem, el tercero cant de hilos para hacer el proceso
    usuario.setPass(hash);
        unUsuarioServicio.agregarUsuario(usuario);

    }
}
