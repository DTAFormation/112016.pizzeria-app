package fr.pizzeria.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

@Table(name = "livreur")
public class Livreur extends Personne {

	public Livreur() {

	}

	public Livreur(String nom, String prenom, String email, String motDePasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
	}

	public Livreur(String nom, String prenom, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public Livreur(int id, String nom, String prenom, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
}
