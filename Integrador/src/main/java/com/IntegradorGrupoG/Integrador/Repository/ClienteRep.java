package com.IntegradorGrupoG.Integrador.Repository;


import com.IntegradorGrupoG.Integrador.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRep extends JpaRepository<Cliente, Integer> {
    List<Cliente> findAllByEstado(boolean baja);
}
