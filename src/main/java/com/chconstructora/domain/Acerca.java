
package com.chconstructora.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

	
@Data
@Entity
@Table(name="acerca")
public class Acerca implements Serializable {
    private static final long serialVersionUID = 1L; /*Autoincremeta valores en 1*/
	  
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="id_acerca")
	  private long idAcerca;
	
	  private String nombre;
	  private String descripcion;
	  
	
	    public Acerca() {
	    }

    public Acerca(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
	
     
}
