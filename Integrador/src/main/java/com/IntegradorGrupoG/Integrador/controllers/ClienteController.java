package com.IntegradorGrupoG.Integrador.controllers;

import com.IntegradorGrupoG.Integrador.dao.ClienteDao;
import com.IntegradorGrupoG.Integrador.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ClienteController  {
//public class ClienteController implements ClienteDao {

    @Autowired
    private ClienteDao unDao; //inyeccion de dependencias

    @RequestMapping(value = "cliente/{id}")
    public Cliente getCliente(@PathVariable int id){
        Cliente unCliente = new Cliente();
        unCliente.setIdCliente(1);
        unCliente.setDni("32233223");
        unCliente.setApellido("Apell");
        unCliente.setNombre("Nom");
        unCliente.setDireccion("Ruta 1");
        unCliente.setEmail("Correo@asdasd.com");
        unCliente.setFechaNac(new Date());
        unCliente.setTel(375845454);


        return unCliente;
    }
    @RequestMapping(value = "clientes")
    public List<Cliente> getClientes(){
         return unDao.getClientes();

    }

    @RequestMapping(value = "cliente1")
    public Cliente modificarCliente(){
        Cliente unCliente = new Cliente();
        unCliente.setIdCliente(1);
        unCliente.setDni("32233223");
        unCliente.setApellido("Apell");
        unCliente.setNombre("Nom");
        unCliente.setDireccion("Ruta 1");
        unCliente.setEmail("Correo@asdasd.com");
        unCliente.setFechaNac(new Date());
        unCliente.setTel(375845454);


        return unCliente;
    }

    @RequestMapping(value = "cliente2")
    public Cliente eliminarCliente(){
        Cliente unCliente = new Cliente();
        unCliente.setIdCliente(1);
        unCliente.setDni("32233223");
        unCliente.setApellido("Apell");
        unCliente.setNombre("Nom");
        unCliente.setDireccion("Ruta 1");
        unCliente.setEmail("Correo@asdasd.com");
        unCliente.setFechaNac(new Date());
        unCliente.setTel(375845454);


        return unCliente;
    }

    @RequestMapping(value = "cliente3")
    public Cliente buscarClientes(){
        Cliente unCliente = new Cliente();
        unCliente.setIdCliente(1);
        unCliente.setDni("32233223");
        unCliente.setApellido("Apell");
        unCliente.setNombre("Nom");
        unCliente.setDireccion("Ruta 1");
        unCliente.setEmail("Correo@asdasd.com");
        unCliente.setFechaNac(new Date());
        unCliente.setTel(375845454);


        return unCliente;
    }
}
