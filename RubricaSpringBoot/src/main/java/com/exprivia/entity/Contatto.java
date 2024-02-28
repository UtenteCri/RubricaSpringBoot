package com.exprivia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Contatto")
public class Contatto {
	@Id
	private String cognome;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String numero;

	public Contatto() {}

	public Contatto(String nome, String cognome, String numero) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Contatti [nome=" + nome + ", cognome=" + cognome + ", numero=" + numero + "]";
	}



}
