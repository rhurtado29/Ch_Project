
package com.chconstructora.service;

import com.chconstructora.domain.Acerca;

import java.util.List;


public interface AcercaService {
     public List<Acerca> getAcercas(boolean activos);
    public Acerca getAcerca(Acerca acerca);
}
