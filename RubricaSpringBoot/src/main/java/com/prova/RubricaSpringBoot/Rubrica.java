package com.prova.RubricaSpringBoot;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Rubrica {
	
	ArrayList<Contatto> listaContatti;
	
	public Rubrica() {
			listaContatti=new ArrayList<Contatto>();
			aggiungiContatto("Luca", "Gialli", "3491212121");
			aggiungiContatto("Mario", "Rossi", "3385353535");
			aggiungiContatto("Guido", "Verdi", "3316464646");
			aggiungiContatto("Andrea", "Bianchi", "33385858585");
	}

	public void aggiungiContatto(Contatto contatto) {
		listaContatti.add(contatto);
		System.out.println("inserito contatto");

	}

	@PostMapping("/aggiungiContatto")
	public void aggiungiContatto(@RequestBody String nome, String cognome, String numero) {
		aggiungiContatto(new Contatto(nome, cognome, numero));
	}
	
	
	@GetMapping("/stampacontatti")
	public String stampaContatti() {
		String stampata = "";
		for (int i = 0; i < listaContatti.size(); i++) {
			Contatto contatto = listaContatti.get(i);
			stampata = stampata + contatto.toString();
		}
		System.out.println(stampata);
		return stampata;
	}
	
	@GetMapping("/cercacontattopercognome/{cognome}")
	public String cercaContattoPerCognome(@PathVariable String cognome) {
		String stampata = "";
		for (int i = 0; i < listaContatti.size(); i++) {
			Contatto contatto = listaContatti.get(i);
			if (contatto.getCognome().equals(cognome)) {
				stampata = stampata + contatto.toString();
			}
		}
		System.out.println(stampata);
		return stampata;
	}
}
