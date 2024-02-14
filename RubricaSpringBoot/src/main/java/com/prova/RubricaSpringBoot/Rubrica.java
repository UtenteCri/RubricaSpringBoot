package com.prova.RubricaSpringBoot;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RubricaController {

	private final static Logger LOGGER = Logger.getLogger(RubricaController.class.getName());

	List<Contatto> listaContatti;

	public RubricaController() {
		listaContatti = new ArrayList<Contatto>();
		aggiungiContatto("Luca", "Gialli", "3491212121");
		aggiungiContatto("Mario", "Rossi", "3385353535");
		aggiungiContatto("Guido", "Verdi", "3316464646");
		aggiungiContatto("Andrea", "Bianchi", "33385858585");
		aggiungiContatto("Maria", "Bianchi", "334555585");
	}

	@PostMapping("/aggiungicontatto")
	public Contatto aggiungiContatto(@RequestParam("nome") String nome, @RequestParam("cognome") String cognome,
			@RequestParam("numero") String numero) {
		Contatto contatto = new Contatto(nome, cognome, numero);
		listaContatti.add(contatto);
		LOGGER.info("inserito contatto" + contatto);
		return contatto;
	}

	public Contatto aggiungiContatto(Contatto contatto) {
		listaContatti.add(contatto);
		LOGGER.info("inserito contatto" + contatto);
		return contatto;
	}

	@GetMapping("/stampacontatti")
	public List<Contatto> stampaContatti() {
		return listaContatti;
	}

	@GetMapping("/cercacontattipercognome/{cognome}")
	public List<Contatto> cercaContattiPerCognome(@PathVariable String cognome) {
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
