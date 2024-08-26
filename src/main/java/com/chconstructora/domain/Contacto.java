
package com.chconstructora.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name="contactos")
public class Contacto implements Serializable  {
     private static final long serialVersionUID = 1L; /*Autoincremeta valores en 1*/
     
      @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="id_contacto")
	  private long idContacto;
          private String nombre;
          private String email;
          private String asunto;
          private String mensaje;
          
	
       public Contacto(){
       
       }   

    public Contacto(long idContacto, Date Fecha) {
        this.idContacto = idContacto;
        
    }
       
    
}
