package com.exprivia.service.impl;

import org.springframework.stereotype.Service;

import com.exprivia.entity.Contatto;
import com.exprivia.service.InterfaceRubricaService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class RubricaService implements InterfaceRubricaService {

    private final static Logger LOGGER = Logger.getLogger(RubricaService.class.getName());

    private List<Contatto> listaContatti;

    public RubricaService() {
        listaContatti = new ArrayList<>();
        aggiungiContatto("Luca", "Gialli", "3491212121");
        aggiungiContatto("Mario", "Rossi", "3385353535");
        aggiungiContatto("Guido", "Verdi", "3316464646");
        aggiungiContatto("Andrea", "Bianchi", "33385858585");
        aggiungiContatto("Maria", "Bianchi", "334555585");
    }

    @Override
    public Contatto aggiungiContatto(String nome, String cognome, String numero) {
        Contatto contatto = new Contatto(nome, cognome, numero);
        return aggiungiContatto(contatto);
    }  
     
    @Override
    public Contatto aggiungiContatto(Contatto contatto) {
        listaContatti.add(contatto);
        LOGGER.info("Inserito contatto: " + contatto);
        return contatto;
    }

    @Override
    public List<Contatto> stampaContatti() {
        return listaContatti;
    }

    @Override
    public List<Contatto> cercaContattiPerCognome(String cognome) {
        List<Contatto> listaBreveContatti = new ArrayList<>();
        for (Contatto contatto : listaContatti) {
            if (contatto.getCognome().equals(cognome)) {
                listaBreveContatti.add(contatto);
            }
        }
        return listaBreveContatti;
    }
}
