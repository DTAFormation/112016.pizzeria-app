package fr.pizzeria.model;

public enum CategoriePizza {
	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");
	
	private String libelle;

	private CategoriePizza(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
	
	@Override
	public String toString() {
		return libelle;
	}
}
