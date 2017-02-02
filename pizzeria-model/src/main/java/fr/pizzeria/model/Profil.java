package fr.pizzeria.model;

public enum Profil{

	ADMINISTRATEUR("Administrateur"), UTILISATEUR("Utilisateur");
	
	private String poste;

	private Profil(String poste) {
		this.poste = poste;
	}

	public String getPoste() {
		return poste;
	}
	
	@Override
	public String toString() {
		return poste;
	}
}
