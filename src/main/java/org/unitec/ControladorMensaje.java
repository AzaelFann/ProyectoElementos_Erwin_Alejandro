/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Azael Fann Heian
 */

@RestController
public class ControladorMensaje {
    
    //Primero hacemos el metodo para guardar
    @Autowired RepositorioMensajes repoMensa;
    @CrossOrigin
    @RequestMapping(value="/mensaje/{titulo}/{cuerpo}", method=RequestMethod.POST, headers={"Accept=text/html"})
    public String guardar(@PathVariable String titulo, @PathVariable String cuerpo){
        repoMensa.save(new Mensaje(titulo, cuerpo));
        return "Mensaje guardado con exito (owo)/";
        
    }
    /*
    @CrossOrigin
    @RequestMapping(value="/mensaje/{id}", method=MethodRequest.GET, headers={"Accept=application/json"})
    public String buscarPorID(@PathVariable Long id) throws Exception{
        Mensaje mensa = repoMensa.findOne(id);
        ObjectMapper maper = new ObjectMapper();
        return maper.writeValueAsString(mensa);
    }
    */
    @CrossOrigin
    @RequestMapping(value="/mensaje", method=RequestMethod.GET, headers={"Accept=application/json"})
    public String buscarTodos()throws Exception{
        ArrayList<Mensaje> mensajes = (ArrayList<Mensaje>) repoMensa.findAll();
        ObjectMapper maper= new ObjectMapper();
        
        
        return maper.writeValueAsString(mensajes);
    }
    
    @CrossOrigin
    @RequestMapping(value="/mensaje/{id}/{titulo}/{cuerpo}", method=RequestMethod.PUT, headers={"Accept=text/html"})

        public String actualizar(@PathVariable Long id, @PathVariable String titulo, @PathVariable String cuerpo){
            Mensaje mensa = new Mensaje(id, titulo, cuerpo);
            repoMensa.save(new Mensaje(id, titulo, cuerpo));
            return "Mensaje actualizado con exito (>3<)/";

}
    
        @CrossOrigin
        @RequestMapping(value="/mensaje/{id}", method=RequestMethod.DELETE, headers={"Accept=test/html"})
        public String borrarPorID(@PathVariable Long id) throws Exception{
            repoMensa.delete(id);
            return "Mensaje Borrado m(uwu)m";
        }
        
}
