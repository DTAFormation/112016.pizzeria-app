package fr.pizzeria.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CategorieBoisson {

	ALCOOL("Alcool"), SANS_ALCOOL("Sans alcool"), GAZ("Gaz"), SANS_GAZ("Sans gaz");

	private String nomCateg;

	private CategorieBoisson(String nomCateg) {
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
