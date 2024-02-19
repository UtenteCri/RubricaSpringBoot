package com.prova.RubricaSpringBoot;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class RubricaService {

    private final static Logger LOGGER = Logger.getLogger(RubricaService.class.getName());

    private List<Contatto> listaContatti;

    public RubricaService() {
        listaContatti = new ArrayList<Contatto>();
        aggiungiContatti("Luca", "Gialli", "3491212121");
        aggiungiContatti("Mario", "Rossi", "3385353535");
        aggiungiContatti("Guido", "Verdi", "3316464646");
        aggiungiContatti("Andrea", "Bianchi", "33385858585");
        aggiungiContatti("Maria", "Bianchi", "334555585");
    }

    public Contatto aggiungiContatti(String nome, String cognome, String numero) {
        Contatto contatto = new Contatto(nome, cognome, numero);
        listaContatti.add(contatto);
        LOGGER.info("Inserito contatto: " + contatto);
        return contatto;
    }

    public List<Contatto> stampaContatti() {
        return listaContatti;
    }

    public List<Contatto> cercaContattiPerCognome(String cognome) {
        List<Contatto> listaBreveContatti = new ArrayList<Contatto>();
        for (int i = 0; i < listaContatti.size(); i++) {
            Contatto contatto = listaContatti.get(i);
            if (contatto.getCognome().equals(cognome)) {
                listaBreveContatti.add(contatto);
            }
        }
        return listaBreveContatti;
    }
}
