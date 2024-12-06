package com.IntegradorGrupoG.Integrador.Services;

import com.IntegradorGrupoG.Integrador.Repository.ProductoRep;
import com.IntegradorGrupoG.Integrador.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServ {


    @Autowired
    ProductoRep unProductoServ;

    public ProductoServ (ProductoRep unCliReo) {
        this.unProductoServ = unCliReo;
    }

    public void agregarProducto(Producto pro) {
        unProductoServ.save(pro);
    }

    public List<Producto> buscarProductoAlta() {
        return unProductoServ.findAllByEstado(true);
    }

    public Producto buscarProductoPorId(int id) {
        return unProductoServ.findById(id).
                orElseThrow(() -> new EntidadNoEncontradaExcepcion(id));
    }

    public void actualizarProductoPorId(int id, Producto unPro) {
        unProductoServ.findById(id).
                ifPresent(proObtenido -> {
                    proObtenido.setNombre(unPro.getNombre());
                    proObtenido.setCantidad(unPro.getCantidad());
                    proObtenido.setEstado(unPro.isEstado());
                    proObtenido.setMarca(unPro.getMarca());
                    proObtenido.setPrecio(unPro.getPrecio());
                    proObtenido.setDescripcion(unPro.getDescripcion());
                    proObtenido.setCategoria(unPro.getCategoria());
                    unProductoServ.save(proObtenido);
                });
    }

    public void eliminarProPorId(int id) {
        unProductoServ.findById(id).
                ifPresent(unPro -> {
                    unPro.setEstado(false);
                    unProductoServ.save(unPro);
                });
    }
}
