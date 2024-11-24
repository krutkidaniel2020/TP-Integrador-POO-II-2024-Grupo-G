package com.IntegradorGrupoG.Integrador.controllers;

import com.IntegradorGrupoG.Integrador.dao.ClienteDao;
import com.IntegradorGrupoG.Integrador.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ClienteController  {
//public class ClienteController implements ClienteDao {

    @Autowired
    private ClienteDao unDao; //inyeccion de dependencias

    @RequestMapping(value = "api/cliente/{id}")
    public Cliente getCliente(@PathVariable int id){
        Cliente unCliente = new Cliente();
        unCliente.setIdCliente(1);
        unCliente.setDni("32233223");
        unCliente.setApellido("Apell");
        unCliente.setNombre("Nom");
        unCliente.setDireccion("Ruta 1");
        unCliente.setEmail("Correo@asdasd.com");
        unCliente.setFecha("11/11/2024");
        unCliente.setTel(375845454);


        return unCliente;
    }
    @RequestMapping(value = "api/clientes", method = RequestMethod.GET)
    public List<Cliente> getClientes(){
         return unDao.getClientes();

    }
    @RequestMapping(value = "api/clientes", method = RequestMethod.POST)
    public void agregarCliente(@RequestBody Cliente cliente){ //convierte lo que recibe en usuario
      unDao.agregarCliente(cliente);

    }

    @RequestMapping(value = "api/cliente1")
    public Cliente modificarCliente(){
        Cliente unCliente = new Cliente();
        unCliente.setIdCliente(1);
        unCliente.setDni("32233223");
        unCliente.setApellido("Apell");
        unCliente.setNombre("Nom");
        unCliente.setDireccion("Ruta 1");
        unCliente.setEmail("Correo@asdasd.com");
        unCliente.setFecha("11/11/2024");
        unCliente.setTel(375845454);


        return unCliente;
    }

    @RequestMapping(value = "api/cliente/{id}",method = RequestMethod.DELETE)
    public void eliminarCliente(@PathVariable int id){
       unDao.elimunarCliente(id);
    }



    @RequestMapping(value = "api/cliente3", method = RequestMethod.GET)
    public Cliente buscarClientes(){
        Cliente unCliente = new Cliente();
        unCliente.setIdCliente(1);
        unCliente.setDni("32233223");
        unCliente.setApellido("Apell");
        unCliente.setNombre("Nom");
        unCliente.setDireccion("Ruta 1");
        unCliente.setEmail("Correo@asdasd.com");
        unCliente.setFecha("11/11/2024");
        unCliente.setTel(375845454);


        return unCliente;
    }

}
