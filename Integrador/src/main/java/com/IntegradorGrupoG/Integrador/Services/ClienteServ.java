package com.IntegradorGrupoG.Integrador.Services;

import com.IntegradorGrupoG.Integrador.Repository.CategoriaRep;
import com.IntegradorGrupoG.Integrador.Repository.ClienteRep;
import com.IntegradorGrupoG.Integrador.models.Categoria;
import com.IntegradorGrupoG.Integrador.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServ {


    @Autowired
    ClienteRep unClienteRep;

    public ClienteServ (ClienteRep unCliReo) {
        this.unClienteRep = unCliReo;
    }

    public void agregarCliente(Cliente cli) {
        unClienteRep.save(cli);
    }

    public List<Cliente> buscarClienteAlta() {
        return unClienteRep.findAllByEstado(true);
    }

    public Cliente buscarClientePorId(int id) {
        return unClienteRep.findById(id).
                orElseThrow(() -> new EntidadNoEncontradaExcepcion(id));
    }

    public void actualizarClientePorId(int id, Cliente unCli) {
        unClienteRep.findById(id).
                ifPresent(cliObtenido -> {
                    cliObtenido.setNombres(unCli.getNombres());
                    cliObtenido.setApellido(unCli.getApellido());
                    cliObtenido.setDni(unCli.getDni());
                    cliObtenido.setDireccion(unCli.getDireccion());
                    cliObtenido.setFecha(unCli.getFecha());
                    cliObtenido.setTel(unCli.getTel());
                    cliObtenido.setPass(unCli.getPass());
                    unClienteRep.save(cliObtenido);
                });
    }

    public void eliminarCliPorId(int id) {
        unClienteRep.findById(id).
                ifPresent(clienteObtenido -> {
                    clienteObtenido.setEstado(false);
                    unClienteRep.save(clienteObtenido);
                });
    }

}
