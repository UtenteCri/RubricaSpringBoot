package com.exprivia.service.impl;

import org.springframework.stereotype.Service;

import com.exprivia.entity.Contatto;
import com.exprivia.service.RubricaServiceInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class RubricaService implements RubricaServiceInterface {

    private final static Logger LOGGER = Logger.getLogger(RubricaService.class.getName());

    private List<Contatto> listaContatti;

    public RubricaService() {
        listaContatti = new ArrayList<>();
        aggiungiContatti("Luca", "Gialli", "3491212121");
        aggiungiContatti("Mario", "Rossi", "3385353535");
        aggiungiContatti("Guido", "Verdi", "3316464646");
        aggiungiContatti("Andrea", "Bianchi", "33385858585");
        aggiungiContatti("Maria", "Bianchi", "334555585");
    }

    @Override
    public Contatto aggiungiContatti(String nome, String cognome, String numero) {
        Contatto contatto = new Contatto(nome, cognome, numero);
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
