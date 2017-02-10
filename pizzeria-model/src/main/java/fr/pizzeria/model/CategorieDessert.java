package fr.pizzeria.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CategorieDessert {
	GLUTEN("Gluten"),SANS_GLUTEN("Sans gluten");
	
	private String nomCateg;

	private CategorieDessert(String nomCateg) {
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
