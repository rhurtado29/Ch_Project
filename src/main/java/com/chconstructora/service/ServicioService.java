
package com.chconstructora.service;

import com.chconstructora.domain.Servicio;
import java.util.List;


public interface ServicioService {
     public List<Servicio> getServicios(boolean activos);
    public Servicio getServicio(Servicio servicio);
}
