
package com.chconstructora.service.impl;

import com.chconstructora.dao.ServicioDao;
import com.chconstructora.domain.Servicio;
import com.chconstructora.service.ServicioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioServiceImpl implements ServicioService {
    //Clase para acceder a base de datos
	    @Autowired
	    private ServicioDao servicioDao;
            
             @Override
	   public List<Servicio> getServicios(boolean activos) {
        /* Con el framework findAll me hace un select * */
        var lista = servicioDao.findAll();

        return lista;

}
           @Override
    @Transactional(readOnly = true)
    public Servicio getServicio(Servicio servicio){
        return servicioDao.findById(servicio.getIdServicio()).orElse(null);
    
    }


}
