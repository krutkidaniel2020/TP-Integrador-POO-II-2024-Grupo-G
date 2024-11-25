package com.IntegradorGrupoG.Integrador.controllers;

import com.IntegradorGrupoG.Integrador.Services.ClienteServicio;
import com.IntegradorGrupoG.Integrador.models.Cliente;
import com.IntegradorGrupoG.Integrador.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador de Cliente
 */
@RestController
public class ClienteController  {

    /**
     * Variable unCliSer para la iny de dependencias
     */
    @Autowired
    private ClienteServicio unCliServ; //inyeccion de dependencias

    /**
     * Variable jwutil para el user y token
     */
    @Autowired
    private JWTUtil jwutil;

    /**
     * Funcion que devuelve la lista de clientes
     * @param id del cliente
     * @return el cliente buscado
     */
    @RequestMapping(value = "api/cliente/{id}")
    public Cliente getCliente(@PathVariable int id){
        Cliente unCliente = new Cliente();
        unCliente.setId(1);
        unCliente.setDni("32233223");
        unCliente.setApellido("Apell");
        unCliente.setNombre("Nom");
        unCliente.setDireccion("Ruta 1");
        unCliente.setEmail("Correo@asdasd.com");
        unCliente.setFecha("11/11/2024");
        unCliente.setTel(375845454);

        return unCliente;
    }

    /**
     * Funcion que devuelve la lista de clientes
     * @param token de seguridad si esta logueado
     * @return lista de clientes o array vacio
     */
    @RequestMapping(value = "api/clientes", method = RequestMethod.GET)
    public List<Cliente> getClientes(@RequestHeader (value="Authorization") String token){
        if (!validarToken(token)){return new ArrayList<>();}
            return unCliServ.getClientes();
    }


    /**
     * Funcion validar token de seguridad
     * @param token de seguridad
     * @return correcto o falso
     */
    private boolean validarToken(String token){
        String clienteId = jwutil.getKey(token);
        if(clienteId==null){
            return false;
        }else{
            return true;
        }
    }

    /**
     * Funcion para agregar cliente
     * @param cliente a agregar
     */
    @RequestMapping(value = "api/clientes", method = RequestMethod.POST)
    public void agregarCliente(@RequestBody Cliente cliente){ //convierte lo que recibe en Cliente
      unCliServ.agregarCliente(cliente);
    }

    /**
     * Funcion para eliminar cliente
     * @param token de seguridad
     * @param id del cliente a eliminar
     */
    @RequestMapping(value = "api/clientes/{id}",method = RequestMethod.DELETE)
    public void eliminarCliente(@RequestHeader (value="Authorization") String token,
            @PathVariable int id){
        //if (validarToken(token)){return;} //verif sesion iniciada
       unCliServ.eliminarCliente(id);
    }


}
