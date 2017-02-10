package fr.pizzeria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "promotion")
public class Promotion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String code;
	private String nom; // Pour identifier la promotion
	private String type; //Pourcentage ou monétaire €
	private Integer montant; // montant de la reduction
	
public Promotion(){
		
	}
	
	public Promotion(String nom, String code, String type, Integer montant){
		
		this.nom=nom;
		this.code=code;
		this.type=type;
		this.montant= montant;
		
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Integer getMontant() {
		return montant;
	}


	public void setMontant(Integer montant) {
		this.montant = montant;
	}
	
	
	
}
