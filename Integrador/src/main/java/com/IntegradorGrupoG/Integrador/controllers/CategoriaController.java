package com.IntegradorGrupoG.Integrador.controllers;


import com.IntegradorGrupoG.Integrador.Services.CategoriaServicio;
import com.IntegradorGrupoG.Integrador.models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriaController {
    @Autowired
    private CategoriaServicio unDao; //inyeccion de dependencias

    @RequestMapping(value = "api/categorias")
    public List<Categoria> getCategorias(){
        return unDao.getCategorias();

    }
}
