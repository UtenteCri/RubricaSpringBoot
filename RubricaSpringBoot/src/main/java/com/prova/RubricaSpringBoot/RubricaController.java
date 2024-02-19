package com.prova.RubricaSpringBoot;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RubricaController {

    private final static Logger LOGGER = Logger.getLogger(RubricaController.class.getName());

    @Autowired
    private RubricaServiceInterface rubricaService; // Modifica qui per iniettare l'interfaccia

    @PostMapping("/aggiungicontatti")
    public Contatto aggiungiContatti(@RequestParam("nome") String nome, @RequestParam("cognome") String cognome,
                                      @RequestParam("numero") String numero) {
        return rubricaService.aggiungiContatti(nome, cognome, numero);
    }

    @GetMapping("/stampacontatti")
    public List<Contatto> stampaContatti() {
        return rubricaService.stampaContatti();
    }

    @GetMapping("/cercacontattipercognome/{cognome}")
    public List<Contatto> cercaContattiPerCognome(@PathVariable String cognome) {
        return rubricaService.cercaContattiPerCognome(cognome);
    }
}
