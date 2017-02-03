package fr.pizzeria.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Entree {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private BigDecimal prix;
	private String urlImage;
	private String type;
	@Enumerated(EnumType.STRING)
	private CategorieEntree categorie;

	public Entree() {

	}

	public Entree(String nom, BigDecimal prix, String urlImage, CategorieEntree categorie) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.urlImage = urlImage;
		this.type = "entree";
		this.categorie = categorie;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public CategorieEntree getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieEntree categorie) {
		this.categorie = categorie;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

}
