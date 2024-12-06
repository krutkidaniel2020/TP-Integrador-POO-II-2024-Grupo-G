package com.IntegradorGrupoG.Integrador.Services;
import com.IntegradorGrupoG.Integrador.Repository.CategoriaRep;
import com.IntegradorGrupoG.Integrador.models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoriaServ {

    @Autowired
    CategoriaRep unaCategRep;

    public CategoriaServ (CategoriaRep unaCatImp) {
        this.unaCategRep = unaCatImp;
    }

    public void agregarCategoria(Categoria categ) {
        unaCategRep.save(categ);
    }

    public List<Categoria> buscarCategoriaAlta() {
        return unaCategRep.findAllByEstado(true);
    }

    public Categoria buscarCategoriaPorId(int id) {
        return unaCategRep.findById(id).
                orElseThrow(() -> new EntidadNoEncontradaExcepcion(id));
    }

    public void actualizarCategoriaPorId(int id, Categoria unaCat) {
        unaCategRep.findById(id).
                ifPresent(categObtenida -> {
                    categObtenida.setNombre(unaCat.getNombre());
                    categObtenida.setEstado(unaCat.isEstado());
                    unaCategRep.save(categObtenida);
                });
    }

    public void eliminarCategPorId(int id) {
        unaCategRep.findById(id).
                ifPresent(categObtenida -> {
                    categObtenida.setEstado(false);
                    unaCategRep.save(categObtenida);
                });
    }
}
