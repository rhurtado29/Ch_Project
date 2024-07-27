
package com.chconstructora.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="proyecto")
public class Proyecto implements Serializable {
    
    private static final long serialVersionUID = 1L; /*Autoincremeta valores en 1*/
	  
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="id_proyecto")
	  private long idProyecto;
	  
	  private String nombre;
	  private String descripcion;
          @Column(name = "ruta_imagen")
          private String rutaImagen;
          private boolean activo;

	   

   public Proyecto(){
   }

    public Proyecto(String nombre, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
	
    //commit
}
