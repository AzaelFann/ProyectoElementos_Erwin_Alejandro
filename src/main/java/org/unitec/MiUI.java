/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec;

import com.vaadin.annotations.Theme;
import com.vaadin.server.ClassResource;
import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.Position;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import java.io.File;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Azael Fann Heian
 */
@SpringUI
@Theme("valo")

public class MiUI extends UI {
    
    @Autowired AplicacionServicios bebidas;
    @Autowired RepositorioMensajes repo;
    

    @Override
    protected void init(VaadinRequest request) {
        //Creamos un Layout
        VerticalLayout layout = new VerticalLayout();
        
        //Generamos una etiqueta
        Label etiqueta = new Label("Azael Fann Heian Reffert Lark");
        layout.addComponent(etiqueta);
        
        //vamoa a crear un boton
            Button boton = new Button("Mi Primer Boton");
            boton.addStyleName(ValoTheme.BUTTON_DANGER);

            boton.addClickListener(cliqueo -> {
                //El siguiente es el constructor de la clase Notification:

                //invocamos un insert
                //repo.save(new Mensaje ("Segundo Mensaje","Mi segundo mensajito"));
                
                //vamo a buscar por id
                //Mensaje mensa = repo.findOne(1L);
                
              //  List<Mensaje> mensajes = (List<Mensaje>) repo.findAll();
                /*
                //un update incorrecto
                Mensaje m = new Mensaje();
                //no existe update
                
                Mensaje msg = repo.findOne(1L);
                msg.setCuerpo("El nuevo cuerpo del primero");
                repo.save(msg);
                */
                
                
             //   repo.delete(6L);
             
             //repoDepto.save(new Departamento("Ventas"));
              
             //Estacionamiento esta = new Estacionamiento();
             //repoEsta.save(esta);
             //repoCli.save(new Cliente(new Estacionamiento(1L, new Date())));
             /*
             Estacionamiento esta = new Estacionamiento(1L, new Date());
             repoEsta.save(esta);
             repoCli.save(new Cliente(esta));
             */
             
             
             
            
            
            Notification notif = new Notification(
                    "PELIGRO",
                    
                    Type.TRAY_NOTIFICATION);
            
            //Algunas propiedades de la clase notificacion
            notif.setDelayMsec(5000);
            notif.setPosition(Position.TOP_RIGHT);
            notif.setStyleName(ValoTheme.NOTIFICATION_SUCCESS);
            notif.setIcon(new FileResource(new File("src/main/resources/token_dragon.png")));
          //notif.setIcon(new ClassResource("token_dragon.png")); 

// Mostrar el mensaje de notificacion en la pagina actual
            notif.show(Page.getCurrent());

        });
        
        layout.addComponent(boton);
        Label etiquetaRecomendacion = new Label();
        //Agregamos
        
        
        etiquetaRecomendacion.setValue(bebidas.obtenerBebidas().obtenerRecomendacion());
        layout.addComponent(etiquetaRecomendacion);
        
        
        //estaline siempre va al final
        setContent(layout);
    }
    
}
