package com.IntegradorGrupoG.Integrador.controllers;

import com.IntegradorGrupoG.Integrador.Services.UsuarioServicio;
import com.IntegradorGrupoG.Integrador.models.Usuario;
import com.IntegradorGrupoG.Integrador.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioServicio unUserServ;

    @Autowired //inyeccion de dependencias
    private JWTUtil jwtutil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){ //convierte lo que recibe en usuario
        Usuario userLog = unUserServ.obtenerUsuarioCredenciales(usuario);
       if ( userLog != null){

        String tokenJWT = jwtutil.create(String.valueOf(userLog.getId()),userLog.getDni());


           return tokenJWT;
       }else{
           return "FAIL";
       }


    }

}
