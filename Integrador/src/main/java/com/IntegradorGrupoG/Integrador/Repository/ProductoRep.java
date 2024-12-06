package com.IntegradorGrupoG.Integrador.Repository;



import com.IntegradorGrupoG.Integrador.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRep extends JpaRepository<Producto, Integer> {
    List<Producto> findAllByEstado(boolean baja);
}
