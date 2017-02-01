package fr.pizzeria.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dessert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private BigDecimal prix;
	private String urlImage;
	private String type;

	public Dessert() {

	}

	public Dessert(String nom, BigDecimal prix, String urlImage) {
		super();

		this.nom = nom;
		this.prix = prix;
		this.urlImage = urlImage;
		type = "dessert";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrl_Image(String urlImage) {
		this.urlImage = urlImage;
	}

}
