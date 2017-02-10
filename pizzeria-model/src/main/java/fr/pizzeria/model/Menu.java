package fr.pizzeria.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private BigDecimal prix;
	private String urlImage;
	private int nbPizza, nbEntree, nbDessert, nbBoisson;
	
	

	public Menu() {

	}

	public Menu(String nom, BigDecimal prix, String urlImage, int nbEntree, int nbPizza, int nbDessert, int nbBoisson) {
		super();

		this.nom = nom;
		this.prix = prix;
		this.urlImage = urlImage;
		this.nbBoisson = nbBoisson;
		this.nbEntree = nbEntree;
		this.nbDessert = nbDessert;
		this.nbPizza = nbPizza;
	}

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

	public Integer getNbPizza() {
		return nbPizza;
	}

	public void setNbPizza(Integer nbPizza) {
		this.nbPizza = nbPizza;
	}

	public int getNbEntree() {
		return nbEntree;
	}

	public void setNbEntree(int nbEntree) {
		this.nbEntree = nbEntree;
	}

	public int getNbDessert() {
		return nbDessert;
	}

	public void setNbDessert(int nbDessert) {
		this.nbDessert = nbDessert;
	}

	public int getNbBoisson() {
		return nbBoisson;
	}

	public void setNbBoisson(int nbBoisson) {
		this.nbBoisson = nbBoisson;
	}

}
