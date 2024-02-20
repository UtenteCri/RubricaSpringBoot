package com.exprivia.service;

import java.util.List;

import com.exprivia.entity.Contatto;

public interface RubricaServiceInterface {
    Contatto aggiungiContatti(String nome, String cognome, String numero);
    List<Contatto> stampaContatti();
    List<Contatto> cercaContattiPerCognome(String cognome);
}
