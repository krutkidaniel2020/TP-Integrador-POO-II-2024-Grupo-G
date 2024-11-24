package com.IntegradorGrupoG.Integrador.controllers;


import com.IntegradorGrupoG.Integrador.dao.CategoriaDao;
import com.IntegradorGrupoG.Integrador.models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriaController {
    @Autowired
    private CategoriaDao unDao; //inyeccion de dependencias

    @RequestMapping(value = "categorias")
    public List<Categoria> getCategorias(){
        return unDao.getCategorias();

    }
}
