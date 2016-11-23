/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Azael Fann Heian
 */

@RestController
public class ControladorHola {
    
    @CrossOrigin
    @RequestMapping("/hola")
    
    public  String hola(){
        return "Mi primer Servicio Web";
    }
    
}
