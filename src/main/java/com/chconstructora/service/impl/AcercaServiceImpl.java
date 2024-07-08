
package com.chconstructora.service.impl;

import com.chconstructora.dao.AcercaDao;
import com.chconstructora.dao.ServicioDao;
import com.chconstructora.domain.Acerca;
import com.chconstructora.domain.Servicio;
import com.chconstructora.service.AcercaService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AcercaServiceImpl implements AcercaService {
    //Clase para acceder a base de datos
	    @Autowired
	    private AcercaDao acercaDao;
            
             @Override
	   public List<Acerca> getAcercas(boolean activos) {
        /* Con el framework findAll me hace un select * */
        var lista = acercaDao.findAll();

        return lista;

}
           @Override
    @Transactional(readOnly = true)
    public Acerca getAcerca(Acerca acerca){
        return acercaDao.findById(acerca.getIdAcerca()).orElse(null);
    
    }


}
