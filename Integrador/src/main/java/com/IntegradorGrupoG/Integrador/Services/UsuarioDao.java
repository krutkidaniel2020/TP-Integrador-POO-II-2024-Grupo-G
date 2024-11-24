package com.IntegradorGrupoG.Integrador.Repository;


import com.IntegradorGrupoG.Integrador.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();

    void agregarUsuario(Usuario usuario);
}
