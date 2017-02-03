package fr.pizzeria.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CategorieEntree {

	VIANDE("Viande"), POISSON("Poisson"), VEGE("Vegetarien");

	private String nomCateg;

	private CategorieEntree(String nomCateg) {
		this.nomCateg = nomCateg;
	}

	@JsonValue
	public String getNomCateg() {
		return nomCateg;
	}

	@Override
	public String toString() {
		return nomCateg;
	}

}
