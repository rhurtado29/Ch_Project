/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chconstructora.service;

import com.chconstructora.domain.Contacto;

import java.util.List;

/**
 *
 * @author rebecahurtado
 */
//commit
public interface ContactoService {
    
     /* Define servicios que va a tener esta clase*/
 /*Obtiene un listado de proyectos en un list READ*/
    //READ
    public List<Contacto> getContactos(boolean activos);

    // Se obtiene un Proyecto, a partir del id de un proyecto - READ con parametro
    public Contacto getContacto(Contacto contacto);

    // Se inserta un nuevo proyecto si el id del proyecto esta vacío - CREATE
    // Se actualiza un proyecto si el id del proyecto NO esta vacío - UPDATE
    public void save(Contacto contacto);

    // Se elimina el proyecto que tiene el id pasado por parámetro - DELETE
    public void delete(Contacto contacto);
    
}
