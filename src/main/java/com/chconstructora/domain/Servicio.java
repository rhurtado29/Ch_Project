
package com.chconstructora.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

	
@Data
@Entity
@Table(name="servicio")
public class Servicio implements Serializable {
    private static final long serialVersionUID = 1L; /*Autoincremeta valores en 1*/
	  
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="id_servicio")
	  private long idServicio;
	  
	  private String nombre;
	  private String descripcion;
	  private String  ejemplo;
	
	    public Servicio() {
	    }

    public Servicio(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
	
     
}
