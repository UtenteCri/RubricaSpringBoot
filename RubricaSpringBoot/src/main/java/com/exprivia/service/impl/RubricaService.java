package com.exprivia.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exprivia.entity.Contatto;
import com.exprivia.repository.ContattoRepository;
import com.exprivia.service.InterfaceRubricaService;

@Service
public class RubricaService implements InterfaceRubricaService {
    private final static Logger LOGGER = Logger.getLogger(RubricaService.class.getName());

    @Autowired
    private ContattoRepository repository;

    @Override
    public Contatto aggiungiContatto(String nome, String cognome, String numero) {
        Contatto contatto = new Contatto(nome, cognome, numero);
        return aggiungiContatto(contatto);
    }

    @Override
    public Contatto aggiungiContatto(Contatto contatto) {
        LOGGER.info("Inserito contatto: " + contatto);
        return repository.save(contatto);
    }

    @Override
    public List<Contatto> stampaContatti() {
        return repository.findAll();
    }

    @Override
    public List<Contatto> cercaContattiPerCognome(String cognome) {
        Optional<Contatto> opt = repository.findById(cognome);

        return opt.isPresent() ? Arrays.asList(opt.get()) : new ArrayList<Contatto>();
    }
    
    @Override
    public List<Contatto> cancellaContattiPerCognome(String cognome) {
        repository.deleteById(cognome);
        return new ArrayList<Contatto>();
    }


}
