//comit
package com.chconstructora.service.impl;

import com.chconstructora.dao.ContactoDao;

import com.chconstructora.domain.Contacto;

import com.chconstructora.service.ContactoService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactoServiceImpl implements ContactoService {
    
    @Autowired
    private ContactoDao contactoDao;
    
    
    @Override
    public List<Contacto>getContactos(boolean activos){
        var lista=contactoDao.findAll();
        return lista;
    }
    
     @Override
    @Transactional(readOnly = true)
    public Contacto getContacto(Contacto contacto) {
        return contactoDao.findById(contacto.getIdContacto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Contacto contacto) {
        contactoDao.save(contacto);
    }

    @Override
    @Transactional
    public void delete(Contacto contacto) {
        contactoDao.delete(contacto);
    }
  
}
