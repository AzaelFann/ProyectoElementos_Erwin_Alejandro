/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec;

import java.util.ArrayList;

/**
 *
 * @author Azael Fann Heian
 */
public class BebidasAlcoholicas implements TipoBebidas {
    
    String nombre;
    
   public String obtenerRecomendacion(){
        
       String bebidas = "Brandy, Tequila, Whisky, Vodka, Mezcal, Pulque";
       return bebidas;
       
    }
    
}
