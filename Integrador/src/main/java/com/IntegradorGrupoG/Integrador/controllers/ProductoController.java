package com.IntegradorGrupoG.Integrador.controllers;





import com.IntegradorGrupoG.Integrador.Services.CategoriaServ;
import com.IntegradorGrupoG.Integrador.Services.ProductoServ;
import com.IntegradorGrupoG.Integrador.models.Producto;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;


@Controller
public class ProductoController {

    /**
     * Variable unProdServ para la inyec de depend
     */
    @Autowired
    private ProductoServ unProdServ; //inyeccion de dependencias

    @Autowired
    private CategoriaServ unaCatServ; //inyeccion de dependencias

    public ProductoController(ProductoServ unProdServ, CategoriaServ unaCatServ) {
        this.unProdServ = unProdServ;
        this.unaCatServ = unaCatServ;
    }

    @GetMapping("/productos")
    public String index(Model modelo) {
        var productos = unProdServ.buscarProductoAlta();
        modelo.addAttribute("productos", productos);
        return "productos";
    }

    @GetMapping("/productos/crear")
    public String nuevoProducto(Model modelo) {
        var prod = new Producto();
        var categorias = unaCatServ.buscarCategoriaAlta();
        modelo.addAttribute("producto", prod);
        modelo.addAttribute("categorias", categorias);
        return "nuevoProducto";
    }

/*    @PostMapping("/productos")
    public String agregarProducto (@Valid Producto prod, BindingResult resultado) {
        if (resultado.hasErrors()) {
            return "nuevoProducto";
        }
        unProdServ.agregarProducto(prod);
        return "redirect:/productos";
    } */
    @PostMapping("/productos")
    public String agregarProducto (@Valid Producto prod, BindingResult resultado, Model modelo) {
        if (resultado.hasErrors()) {
            modelo.addAttribute("categorias", unaCatServ.buscarCategoriaAlta());
            //System.out.println(unaCatServ.buscarCategoriaAlta().toString());
            return "nuevoProducto";
        }
        unProdServ.agregarProducto(prod);
        return "redirect:/productos";
    }


    @GetMapping("/productos/{id}/editar") //    @GetMapping("/productos/{id}/editar"), en editar probar ver
    public String editarProducto(@PathVariable("id") Integer id, Model modelo) {
        modelo.addAttribute("producto", unProdServ.buscarProductoPorId(id));
        modelo.addAttribute("categorias", unaCatServ.buscarCategoriaAlta());
        return "actualizarProducto";
    }

    @PutMapping("/productos/{id}")
    public String actualizarProducto(@PathVariable("id") Integer id, @Valid Producto prod, BindingResult resultado) {
        if (resultado.hasErrors()) {
            return "actualizarProducto";
        }
        unProdServ.actualizarProductoPorId(id, prod);
        return "redirect:/productos";
    }

    @DeleteMapping("/productos/{id}")
    public String eliminarProducto(@PathVariable("id") Integer id) {
        unProdServ.eliminarProPorId(id);
        return "redirect:/productos";
    }



}
