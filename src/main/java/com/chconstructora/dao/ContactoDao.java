
package com.chconstructora.dao;

import com.chconstructora.domain.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoDao  extends JpaRepository<Contacto,Long>  {
    
}
