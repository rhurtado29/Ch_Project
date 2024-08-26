package com.chconstructora.controller;

import com.chconstructora.service.AcercaService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/proyecto")
public class AcabadoController {
   

    @GetMapping("/acabados")
    public String about(Model model) {
        
        model.addAttribute("acabados", "this is the personalization page");
        return "proyecto/acabados"; 
    }
   
}
