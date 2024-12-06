package com.IntegradorGrupoG.Integrador.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador de Login
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String index(Model modelo) {
        //var categorias = unaCatServ.buscarCategoriaAlta();
        modelo.addAttribute("login", null);
        return "login";
    }

}
