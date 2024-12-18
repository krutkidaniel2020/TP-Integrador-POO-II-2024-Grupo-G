package com.IntegradorGrupoG.Integrador.Repository;


import com.IntegradorGrupoG.Integrador.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRep extends JpaRepository<Categoria, Integer> {

    List<Categoria> findAllByEstado(boolean baja);

}
