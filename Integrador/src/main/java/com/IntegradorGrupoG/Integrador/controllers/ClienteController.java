package com.IntegradorGrupoG.Integrador.controllers;

import com.IntegradorGrupoG.Integrador.Services.ClienteServ;

import com.IntegradorGrupoG.Integrador.models.Cliente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


/**
 * Controlador de Cliente
 */
@Controller
public class ClienteController  {

    /**
     * Variable unCliSer para la iny de dependencias
     */
    @Autowired
    private ClienteServ unCliServ; //inyeccion de dependencias

    public ClienteController(ClienteServ unClienteServ) {

        this.unCliServ = unClienteServ;
    }

    @GetMapping("/clientes")
    public String index(Model modelo) {
        var clientes = unCliServ.buscarClienteAlta();
        modelo.addAttribute("clientes", clientes);
        return "clientes";
    }

    @GetMapping("/clientes/crear")
    public String nuevoCliente(Model modelo) {
        var cli = new Cliente();
        modelo.addAttribute("cliente", cli);
        return "nuevoCliente";
    }

    @PostMapping("/clientes")
    public String agregarCliente (@Valid Cliente cli, BindingResult resultado) {
        if (resultado.hasErrors()) {
            return "nuevoCliente";
        }
        unCliServ.agregarCliente(cli);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{id}/editar")
    public String editarCliente(@PathVariable("id") Integer id, Model modelo) {
        modelo.addAttribute("cliente", unCliServ.buscarClientePorId(id));
        return "actualizarCliente";
    }

    @PutMapping("/clientes/{id}")
    public String actualizarCliente(@PathVariable("id") Integer id, @Valid Cliente cli, BindingResult resultado) {
        if (resultado.hasErrors()) {
            return "actualizarCliente";
        }
        unCliServ.actualizarClientePorId(id, cli);
        return "redirect:/clientes";
    }

    @DeleteMapping("/clientes/{id}")
    public String eliminarCliente(@PathVariable("id") Integer id) {
        unCliServ.eliminarCliPorId(id);
        return "redirect:/clientes";
    }


    @GetMapping("/clientes/registroCliente")
    public String registroCliente(Model modelo) {
        var cli = new Cliente();
        modelo.addAttribute("cliente", cli);
        return "registroCliente";
    }

}
