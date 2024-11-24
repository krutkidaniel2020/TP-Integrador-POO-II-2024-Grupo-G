package com.IntegradorGrupoG.Integrador.controllers;


import com.IntegradorGrupoG.Integrador.Services.ProductoServicio;

import com.IntegradorGrupoG.Integrador.models.Cliente;
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

    @Autowired
    private ProductoServicio unDao; //inyeccion de dependencias
    @Autowired
    private JWTUtil jwutil;

   // @RequestMapping(value = "api/productos")
  //  public List<Producto> getProductos(){
    //    return unDao.getProductos();

   // }

    @RequestMapping(value = "api/productos")
    public List<Producto> getProductos(@RequestHeader(value="Authorization") String token){
        if (!validarToken(token)){return new ArrayList<>();}

        return unDao.getProductos();
    }
    private boolean validarToken(String token){
        // public List<Cliente> getClientes(){
        //jwutil.getKey() devuelve el id
        //jwutil.getValue() devuelve en este caso el dni asignado en AuthController

        String prodId = jwutil.getKey(token);
        if(prodId==null){
            //ArrayList aa = new ArrayList<>();
            //aa.add("Sesion cerrada");
            // return clienteId != null;
            return false;

        }else{
            return true;
        }

    }



}
