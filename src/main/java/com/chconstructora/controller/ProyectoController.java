
package com.chconstructora.controller;

import com.chconstructora.domain.Proyecto;
import com.chconstructora.service.ProyectoService;
import com.chconstructora.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/proyecto")
public class ProyectoController {
    @Autowired 
    private ProyectoService proyectoService;
    
     @GetMapping("/listado")
    public String inicio(Model model) {
        var proyectos = proyectoService.getProyectos(false);
        model.addAttribute("proyectos", proyectos);
        model.addAttribute("totalProyectos", proyectos.size());
        return "/proyecto/listado";
    }
     @GetMapping("/nuevo")
    public String proyectoNuevo(Proyecto proyecto) {
        return "/proyecto/modifica";
    }
     @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
     @PostMapping("/guardar")
    public String proyectoGuardar(Proyecto proyecto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            proyectoService.save(proyecto);
            proyecto.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "proyecto", 
                            proyecto.getIdProyecto()));
        }
        proyectoService.save(proyecto);
        return "redirect:/proyecto/listado";
    }

    @GetMapping("/eliminar/{idProyecto}")
    public String proyectoEliminar(Proyecto proyecto) {
        proyectoService.delete(proyecto);
        return "redirect:/proyecto/listado";
    }

    @GetMapping("/modificar/{idProyecto}")
    public String proyectoModificar(Proyecto proyecto, Model model) {
        proyecto = proyectoService.getProyecto(proyecto);
        model.addAttribute("proyecto", proyecto);
        return "/proyecto/modifica";
    }
    
    
}
