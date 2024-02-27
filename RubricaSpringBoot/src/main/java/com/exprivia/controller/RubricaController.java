package com.exprivia.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exprivia.entity.Contatto;
import com.exprivia.service.InterfaceRubricaService;

@RestController
public class RubricaController {

    private final static Logger LOGGER = Logger.getLogger(RubricaController.class.getName());

    @Autowired
    private InterfaceRubricaService rubricaService; // Modifica qui per iniettare l'interfaccia

    
    @PostMapping("/contatti")
    public Contatto aggiungiContatto(@RequestBody Contatto contatto) {
        return rubricaService.aggiungiContatto(contatto);
    }

    @GetMapping("/contatti")
    public List<Contatto> stampaContatti() {
        return rubricaService.stampaContatti();
    }

    @GetMapping("/contatti/{cognome}")
    public List<Contatto> cercaContattiPerCognome(@PathVariable String cognome) {
        return rubricaService.cercaContattiPerCognome(cognome);
    }
}
