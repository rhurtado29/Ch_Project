//comit
package com.chconstructora.service.impl;

import com.chconstructora.dao.ProyectoDao;
import com.chconstructora.domain.Proyecto;
import com.chconstructora.service.ProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProyectoServiceImpl implements ProyectoService {
    
    @Autowired
    private ProyectoDao proyectoDao;
    
    
    @Override
    public List<Proyecto>getProyectos(boolean activos){
        var lista=proyectoDao.findAll();
        return lista;
    }
    
     @Override
    @Transactional(readOnly = true)
    public Proyecto getProyecto(Proyecto proyecto) {
        return proyectoDao.findById(proyecto.getIdProyecto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Proyecto proyecto) {
        proyectoDao.save(proyecto);
    }

    @Override
    @Transactional
    public void delete(Proyecto proyecto) {
        proyectoDao.delete(proyecto);
    }
  
}
