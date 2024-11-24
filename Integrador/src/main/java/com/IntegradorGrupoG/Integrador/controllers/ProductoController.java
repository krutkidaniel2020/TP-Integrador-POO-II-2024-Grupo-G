package com.IntegradorGrupoG.Integrador.controllers;


import com.IntegradorGrupoG.Integrador.dao.ProductoDao;

import com.IntegradorGrupoG.Integrador.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private ProductoDao unDao; //inyeccion de dependencias

    @RequestMapping(value = "api/productos")
    public List<Producto> getProductos(){
        return unDao.getProductos();

    }

}
