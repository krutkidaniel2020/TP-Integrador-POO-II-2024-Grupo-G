package com.IntegradorGrupoG.Integrador.Services;

import com.IntegradorGrupoG.Integrador.models.Producto;
import java.util.List;

/**
 * Interface del Producto
 */
public interface ProductoServicio {


    /**
     * Funcion que devuelve la lista de productos
     * @return lista de productos
     */
    List<Producto> getProductos();
}
