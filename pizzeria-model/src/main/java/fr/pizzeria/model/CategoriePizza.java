package fr.pizzeria.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CategoriePizza {
	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");

	private String libelle;

	private CategoriePizza(String libelle) {
		this.libelle = libelle;
	}

	@JsonValue
	public String getLibelle() {
		return libelle;
	}

	@Override
	public String toString() {
		return libelle;
	}
}
