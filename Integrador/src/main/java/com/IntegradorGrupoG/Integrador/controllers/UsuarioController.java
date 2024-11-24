package com.IntegradorGrupoG.Integrador.controllers;



import com.IntegradorGrupoG.Integrador.Services.UsuarioServicio;

import com.IntegradorGrupoG.Integrador.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioServicio unDao; //inyeccion de dependencias

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(){
        return unDao.getUsuarios();

    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void agregarUsuario(@RequestBody Usuario usuario){ //convierte lo que recibe en usuario
        unDao.agregarUsuario(usuario);

    }
}
