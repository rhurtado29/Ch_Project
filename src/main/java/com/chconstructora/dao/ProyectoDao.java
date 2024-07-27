/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chconstructora.dao;

import com.chconstructora.domain.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rebecahurtado
 */
//commit
public interface ProyectoDao extends JpaRepository<Proyecto,Long> {
    
}
