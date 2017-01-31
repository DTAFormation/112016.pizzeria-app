package fr.pizzeria.model;

public enum Statut {
	EN_PREPARATION("En cours de préapartion"), EN_CUISSON("En cours de cuisson"), EN_LIVRAISON(
			"En cours de livraison"), PRET("Prête à emporter"), LIVRER("Livré");

	private String label;

	private Statut(String label) {
		this.setLabel(label);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
