package com.IntegradorGrupoG.Integrador.controllers;

import com.IntegradorGrupoG.Integrador.Services.ClienteServicio;
import com.IntegradorGrupoG.Integrador.models.Cliente;
import com.IntegradorGrupoG.Integrador.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClienteController  {
//public class ClienteController implements ClienteDao {

    @Autowired
    private ClienteServicio unDao; //inyeccion de dependencias
    @Autowired
    private JWTUtil jwutil;

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
    public List<Cliente> getClientes(@RequestHeader (value="Authorization") String token){
if (!validarToken(token)){return new ArrayList<>();}

        return unDao.getClientes();
    }
    private boolean validarToken(String token){
        // public List<Cliente> getClientes(){
        //jwutil.getKey() devuelve el id
        //jwutil.getValue() devuelve en este caso el dni asignado en AuthController

        String clienteId = jwutil.getKey(token);
        if(clienteId==null){
            //ArrayList aa = new ArrayList<>();
            //aa.add("Sesion cerrada");
           // return clienteId != null;
        return false;

       }else{
            return true;
        }

    }

    @RequestMapping(value = "api/clientes", method = RequestMethod.POST)
    public void agregarCliente(@RequestBody Cliente cliente){ //convierte lo que recibe en Cliente
      unDao.agregarCliente(cliente);

    }



    @RequestMapping(value = "api/clientes/{id}",method = RequestMethod.DELETE)
    public void eliminarCliente(@RequestHeader (value="Authorization") String token,
            @PathVariable int id){
        //if (validarToken(token)){return;} //verif sesion iniciada
       unDao.eliminarCliente(id);
    }





}
