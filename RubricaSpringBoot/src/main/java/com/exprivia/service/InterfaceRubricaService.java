package com.exprivia.service;

import java.util.List;

import com.exprivia.entity.Contatto;

public interface InterfaceRubricaService {
    Contatto aggiungiContatto(String nome, String cognome, String numero);
    List<Contatto> stampaContatti();
    List<Contatto> cercaContattiPerCognome(String cognome);
	Contatto aggiungiContatto(Contatto contatto);
}
