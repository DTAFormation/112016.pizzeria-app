package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@Column(name="nom", length=5000, nullable=false)
	protected String nom;
	@Column(name="prenom", length=5000, nullable=false)
	protected String prenom;
	@Column(name="email", length=5000, nullable=false)
	protected String email;
	@Column(name="mot_de_passe", length=5000, nullable=false)
	protected String motDePasse;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String mot_de_passe) {
		this.motDePasse = mot_de_passe;
	}

}
