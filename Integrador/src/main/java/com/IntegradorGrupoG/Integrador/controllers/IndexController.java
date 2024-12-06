package com.IntegradorGrupoG.Integrador.controllers;

import com.IntegradorGrupoG.Integrador.Services.CategoriaServ;
import com.IntegradorGrupoG.Integrador.Services.ProductoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private CategoriaServ unaCatServ; //inyeccion de dependencias

    @Autowired
    private ProductoServ unProd; //inyeccion de dependencias

    public IndexController(CategoriaServ unaCatServ, ProductoServ unProd) {
        this.unaCatServ = unaCatServ;
        this.unProd = unProd;
    }


    @GetMapping("/") //ruta
    public String index(Model modelo) {
        var categorias = unaCatServ.buscarCategoriaAlta();
        var productos = unProd.buscarProductoAlta();
        modelo.addAttribute("categorias", categorias);
        modelo.addAttribute("productos", productos);
        return "index";
    }
}
