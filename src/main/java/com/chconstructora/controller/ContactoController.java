
package com.chconstructora.controller;

import com.chconstructora.domain.Contacto;

import com.chconstructora.service.ContactoService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/contacto")
public class ContactoController {
     @Autowired 
    private ContactoService contactoService;
    
    @GetMapping("/contacto")
    public String contacto(Model model) {
        
        model.addAttribute("contacto", new Contacto());
        return "contacto/contacto"; 
    }
    
       @PostMapping("/guardar")
    public String contactoGuardar(Contacto contacto, RedirectAttributes redirectAttributes){
          
        contactoService.save(contacto);
        redirectAttributes.addFlashAttribute("successMessage", "Gracias por su mensaje, nos pondremos en contacto con usted lo más pronto posible!");
        return "redirect:/contacto/contacto";
    }
}
