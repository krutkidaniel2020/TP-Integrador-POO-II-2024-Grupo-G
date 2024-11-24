package com.IntegradorGrupoG.Integrador.Services;


import com.IntegradorGrupoG.Integrador.models.Usuario;

import java.util.List;

public interface UsuarioServicio {
    List<Usuario> getUsuarios();

    void agregarUsuario(Usuario usuario);
}
