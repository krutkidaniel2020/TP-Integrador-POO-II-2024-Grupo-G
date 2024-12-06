package com.IntegradorGrupoG.Integrador.controllers;


import com.IntegradorGrupoG.Integrador.Services.CategoriaServ;
import com.IntegradorGrupoG.Integrador.models.Categoria;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador de Categoria
 */
 @Controller //@RestController
public class CategoriaController {

    /**
     * Variable unDao para la inyeccion de dependencias
     */
    @Autowired
    private CategoriaServ unaCatServ; //inyeccion de dependencias

    public CategoriaController(CategoriaServ unaCatServ) {
        this.unaCatServ = unaCatServ;
    }

    @GetMapping("/categorias")
    public String index(Model modelo) {
        var categorias = unaCatServ.buscarCategoriaAlta();
        modelo.addAttribute("categorias", categorias);
        return "categorias";
    }

    @GetMapping("/categorias/crear")
    public String nuevaPersona(Model modelo) {
        var categ = new Categoria();
        modelo.addAttribute("categoria", categ);
        return "nuevaCategoria";
    }

    @PostMapping("/categorias")
    public String agregarCategoria (@Valid Categoria categ, BindingResult resultado) {
        if (resultado.hasErrors()) {
            return "nuevaCategoria";
        }
        unaCatServ.agregarCategoria(categ);
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/{id}/editar")
    public String editarCategoria(@PathVariable("id") Integer id, Model modelo) {
        modelo.addAttribute("categoria", unaCatServ.buscarCategoriaPorId(id));
        return "actualizarCategoria";
    }

    @PutMapping("/categorias/{id}")
    public String actualizarCategoria(@PathVariable("id") Integer id, @Valid Categoria categ, BindingResult resultado) {
        if (resultado.hasErrors()) {
            return "actualizarCategoria";
        }
        unaCatServ.actualizarCategoriaPorId(id, categ);
        return "redirect:/categorias";
    }

    @DeleteMapping("/categorias/{id}")
    public String eliminarCategoria(@PathVariable("id") Integer id) {
        unaCatServ.eliminarCategPorId(id);
        return "redirect:/categorias";
    }

}
