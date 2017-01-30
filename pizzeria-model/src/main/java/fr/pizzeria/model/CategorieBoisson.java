package fr.pizzeria.model;

public enum CategorieBoisson {

	ALCOOL("alcool"), SANS_ALCOOL("sans alcool"), GAZ("gaz"), SANS_GAZ("sans gaz");

	private String nomCateg;

	private CategorieBoisson(String nomCateg) {
		this.nomCateg = nomCateg;
	}

}
