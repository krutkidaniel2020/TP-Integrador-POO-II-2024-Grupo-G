package com.IntegradorGrupoG.Integrador.controllers;


import com.IntegradorGrupoG.Integrador.Services.ProductoServicio;

import com.IntegradorGrupoG.Integrador.models.Producto;
import com.IntegradorGrupoG.Integrador.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductoController {

    /**
     * Variable unProdServ para la inyec de depend
     */
    @Autowired
    private ProductoServicio unProdServ; //inyeccion de dependencias

    /**
     * Variable jwutil para el user y token
     */
    @Autowired
    private JWTUtil jwutil;

    /**
     * Funcion que devuelve la lista de productos
     * @param token de seguridad
     * @return lista de productos si esta logueado
     */
    @RequestMapping(value = "api/productos")
    public List<Producto> getProductos(@RequestHeader(value="Authorization") String token){
        if (!validarToken(token)){return new ArrayList<>();}

        return unProdServ.getProductos();
    }

    /**
     * Funcion para validar el token
     * @param token a buscar
     * @return si es correcto o no
     */
    private boolean validarToken(String token){
        String prodId = jwutil.getKey(token);
        if(prodId==null){
            return false;
        }else{
            return true;
        }
    }



}
