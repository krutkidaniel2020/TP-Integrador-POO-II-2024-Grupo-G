package com.IntegradorGrupoG.Integrador.controllers;


import com.IntegradorGrupoG.Integrador.Services.CategoriaServicio;
import com.IntegradorGrupoG.Integrador.models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Controlador de Categoria
 */
@RestController
public class CategoriaController {

    /**
     * Variable unDao para la inyeccion de dependencias
     */
    @Autowired
    private CategoriaServicio unaCatServ; //inyeccion de dependencias

    /**
     * Funcion que devuelve la lista de categorias
     * @return lista de categorias
     */
    @RequestMapping(value = "api/categorias")
    public List<Categoria> getCategorias(){
        return unaCatServ.getCategorias();

    }
}
