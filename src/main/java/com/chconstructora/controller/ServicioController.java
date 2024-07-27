package com.chconstructora.controller;

import com.chconstructora.service.ServicioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/inicio")
public class ServicioController {
    @Autowired
    private ServicioService servicioService;

    @GetMapping("/servicio")
    public String inicio(Model model) {
        var servicios = servicioService.getServicios(false);
        model.addAttribute("servicios", servicios);
        return "index"; 
    }
    //commit
}
