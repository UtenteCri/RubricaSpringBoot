package com.prova.RubricaSpringBoot;

import java.util.List;

public interface RubricaServiceInterface {
    Contatto aggiungiContatti(String nome, String cognome, String numero);
    List<Contatto> stampaContatti();
    List<Contatto> cercaContattiPerCognome(String cognome);
}
