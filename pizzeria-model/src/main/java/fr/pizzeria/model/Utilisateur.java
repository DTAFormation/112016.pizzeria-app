package fr.pizzeria.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur")
public class Utilisateur extends Personne {

	@Enumerated(EnumType.STRING)
	private Profil profil;

	public Utilisateur() {

	}

	public Utilisateur(String nom, String prenom, String email, String motDePasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
	}

	public Utilisateur(String nom, String prenom, String email, String motDePasse, Profil profil) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.profil = profil;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}
}
